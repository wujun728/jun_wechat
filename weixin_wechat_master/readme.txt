������Ŀʹ�õ��ļ�������

Spring�� hibernate��memcache��Netty��protobuf��FastDFS��GreenDao��

����ͨ�Ų�����netty ��protobuf 


�Ķ���ڣ�weichatApp/org.weishe.weichat.service.Session
	  
          weichat/com.weishe.weichat.core.NettyServerBootstrap

1.���˽���������ϵͳ�����˼·�����Ķ�  doc/�����ͽ��ܺͼܹ�����.ppt
  �����֮������һ���ط�û˵����ľ��Ƿ���˵ĵ���Ϣת������ʱ���һᲹ�ϵġ�
2.������Ŀ��Eclipse��������Դ����������֮���뼴��

3.������Ŀ֮�����޸� weichat/config db-config.properties�ļ��е����ݿ�����
#connection.url=jdbc:mysql://XXXXXXXXXX:3306/WeiChat?autoReconnect=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=utf8
#connection.username= 
#connection.password= 

4.�޸�weichatApp/org.weishe.weichat.api.ApiHttpClient�еķ�������ӵ�ַ
	public final static String HOST = "";
	private static String API_URL = "http:// /weichat/%s";

5.�޸�weichatApp/org.weishe.weichat.service.Session
   129�� ����˶�Ӧ��ַ

6.�޸�FastDFSϵͳ��ַ
 weichatApp/org.weishe.weichat.util ��57��
 weichat/com.weishe.weichat.util.FastDFSUtil ��69��
 
7.�޸�memcache ��ַ  
 weichat/config/applicationContext.xml 240��

8.��Ϊ����ʹ�õķ��������Ҹ��˵�һ���Ʒ���������̫������±������������ַ��صĶ�ȥ���ˡ�
  ���ʹ������ipҲ�ǿ��Եģ�ֻҪ�ֻ����������һ���������м��ɡ�

9.�����Ŀ��android�˵���Щ�ؼ���Ӧ�õ���·���������ѵĵ�Դ�룬���������˿����ߵ���Ϣ���ڴ��ر��л��

10.����������ҵ��ʱ�����ģ���Щ�ط��������кܺõ���Ƶ�������ʱ������.......������û����ϸ�����������Щ��������¡�

11.�������ʻ��ߺõĸ��췽���뷢��������735859399@qq.com
