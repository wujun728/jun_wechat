#include "weixin4c_public.h"
#include "weixin4c_private.h"

int ReceiveEvent( struct Weixin4cEnv *penv , char *post_data , int post_data_len , xml *p_req )
{
	xml	rsp ;
	char	output_buffer[ 2048 ] ;
	int	output_buflen ;
	int	output_bufsize ;
	char	rsp_buffer[ 2048 * 3 ] ;
	int	rsp_buflen ;
	
	int	nret = 0 ;
	
	PUBTakeoffCDATA( p_req->ToUserName );
	PUBTakeoffCDATA( p_req->FromUserName );
	
	memset( output_buffer , 0x00 , sizeof(output_buffer) );
	output_buflen = 0 ;
	output_bufsize = sizeof(output_buffer) ;
	if( penv->pconf->funcs.pfuncReceiveEventProc )
	{
		SetLogFile( "%s/log/%s_ReceiveEventProc.log" , penv->pconf->home , penv->pconf->project_name );
		nret = penv->pconf->funcs.pfuncReceiveEventProc( penv->pconf->user_data , p_req , output_buffer , & output_buflen , & output_bufsize ) ;
		SetLogFile( "%s/log/%s_weixin4c.log" , penv->pconf->home , penv->pconf->project_name );
		if( nret )
		{
			ErrorLog( __FILE__ , __LINE__ , "pfuncReceiveEventProc failed , errno[%d]" , errno );
		}
	}
	
	memset( & rsp , 0x00 , sizeof(xml) );
	SNPRINTF( rsp.ToUserName , sizeof(rsp.ToUserName)-1 , "<![CDATA[%s]]>" , p_req->FromUserName );
	SNPRINTF( rsp.FromUserName , sizeof(rsp.FromUserName)-1 , "<![CDATA[%s]]>" , p_req->ToUserName );
	rsp.CreateTime = (int)time(NULL) ;
	strcpy( rsp.MsgType , "<![CDATA[text]]>" );
	SNPRINTF( rsp.Content , sizeof(rsp.Content)-1 , "<![CDATA[%s]]>" , output_buffer );
	
	memset( rsp_buffer , 0x00 , sizeof(rsp_buffer) );
	rsp_buflen = sizeof(rsp_buffer) - 1 ;
	nret = DSCSERIALIZE_XML_xml( & rsp , "UTF-8" , rsp_buffer , & rsp_buflen ) ;
	if( nret )
	{
		ErrorLog( __FILE__ , __LINE__ , "DSCSERIALIZE_XML_xml failed[%d]" , nret );
	}
	else
	{
		InfoLog( __FILE__ , __LINE__ , "DSCSERIALIZE_XML_xml ok" );
		InfoLog( __FILE__ , __LINE__ , "rsp xml[%d][%.*s]" , rsp_buflen-39 , rsp_buflen-39 , rsp_buffer+39 );
		printf( "%.*s" , rsp_buflen-39 , rsp_buffer+39 );
	}
	
	return 0;
}

