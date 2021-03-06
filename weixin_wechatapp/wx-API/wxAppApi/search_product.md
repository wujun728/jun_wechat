### 商品列表页  pages/search_product/index

### 使用接口

   获取商品列表 Client.Get.ProductListMore （ /more_product_list.html ）

### 链接地址

    获取商品列表  https://mini.sansancloud.com/chainalliance/xianhua/more_product_list.html
  
## 获取商品列表 Client.Get.ProductListMore （ /more_product_list.html ）

###  请求参数 Client.Get.ProductListMore

|名称|说明|是否必要|备注
|:---:|:---:|:---:|:---:|
|categoryId|类型id|否|
|belongShop|所属店铺|否|
|typeBelongShop|所属店铺类别|否|
|page|第几页|否|
|showType|显示方式|否|
|showColumn|显示几列|否|
|categoryId|类型id|否|
|productName|商品名称|否|
|startPrice|最低价格|否|
|endPrice|最高价格|否|
|orderType|排序方式|否|

### 返回字段说明 Client.Get.ProductListMore

|名称|说明|备注
|:---:|:---:|:---:|
|imagePath|产品缩略图|-
|name|产品名|-
|tagPrice|产品标价|-
|price|产品售价|-
|saleCount|销售数量|-
|category|产品分类|-
|description|描述|-
|minSaleCount |最少购买数|-
|pingfen |评分|-
|saleStrategyDetails |销售策略详情|-
|stock |库存|-
|measureItem |是否多规格商品|-
|measureTypes |分配规格类型|-
|brandId |归属品牌id|-
|promotionBean |参与活动Bean|-
|attrs |属性列表|-


### 请求结果: Client.Get.ProductListMore

    {
      "pageSize": 20,
      "curPage": 1,
      "totalSize": 4,
      "result": [
        {
          "jsonRemark":
          "{   beanRemark:'产品Bean',
              imagePath:'产品缩略图',
              name:'产品名',
              tagPrice:'产品标价',
              price:'产品售价',
              price2:'价格2(弃用)',
              price3:'价格3(弃用)',
              saleCount:'销售数量',
              category:'产品分类',
              saleTime:'开售日期',
              hotSale:'热销(弃用)',
              saleStrategy:'销售策略号',
              disable:'是否上架 0上架    1 下架',
              linkUrl:'弃用',
              productCode:'产品编码',
              description:'描述',
              orderNumber:'编码',
              readCount:'访问次数',
              stock:'库存',
              belongAreaId:'弃用',
              belongShangquanId:'弃用',
              belongShopId:'上传店铺ID',
              belongAreaName:'弃用',
              belongShangquanName:'弃用',
              belongShopName:'上传店铺名',
              tags:'商品标签',
              promotion:'参与主活动',
              shopProductType:'店铺分类（与主分类不同 店铺自己对产品的分类）',
              phoneImg:'弃用',
              addTime:'添加时间',
              minSaleCount:'最少购买数',
              bigSmallUnitScale:'大小单位比例（弃用）',
              tip:'tip说明 弃用',
              unitShow:'单位名称（弃用）',
              remarkNumber:'备注号(后端使用 前端忽略)',
              categoryParent:'产品归类父类id',
              categoryGradparent:'产品归类祖先分类ID',
              newSale:'新品 (弃用)',
              brandId:'归属品牌id',
              brandName:'品牌名',
              brandNameEn:'品牌英文名',
              brandNameShort:'品牌缩写',
              commentCount:'评论次数',
              yunfei:'运费(弃用 现在使用平台设定的运费模板)',
              yunfeiTemplate:'运费模板id(弃用 使用平台默认设置的运费模板)',
              productType:'产品类型 0普通产品  1到店服务类产品 2展示类产品 3预收类产品 5租赁类产品',
              presalePrice:'预售价格(预售类产品可用)',
              distributeProfit:'产品分配利润（在二级分润系统使用）',
              daidingPlatformUserId:'待定平台用户id（忽略）',
              daidingTime:'待定时间',
              daidingUserLoginName:'待定用户登录名',
              daidingUserNickName:'待定用户昵称',
              remark:'备注（前端忽略 后端使用）',
              pingfen:'产品评分',
              pingfenCount:'产品参与评分数量',
              leaseUnitTypeStr:'租赁单位类型字符表示',
              leaseUnitType:'租赁单位类型 0小时 1天 2周 3月 4年 （周单位弃用）',
              productYear:'产品年份',
              attributesCombind:'属性归集 ',
              leaseUnitAmount:'租赁单位金额 ',
              leaseUnitExpireAmount:'租赁逾期单位金额 ',
              leaseNeedBackUnitCount:'租赁应还单位时长  如值为 10表示10个单位内应归还 单位参考  leaseUnitType ',
              measureItem:'是否多规格商品 0否 1是 表示有规格 如 红色 L码',
              saleStrategyDetails:'销售策略详情',
              measureTypes:'分配规格类型',
              promotionBean:'参与活动Bean',
              attrs:'属性列表',
              platformNo:'平台号'
           }",
          "id": 8229,
          "imagePath": "http://image1.sansancloud.com/shuiguofenxiao/2017_12/26/12/03/29_458.jpg",
          "name": "新疆阿克苏糖心苹果",
          "tagPrice": 100,
          "price": 100,
          "price2": 0,
          "saleCount": 1,
          "category": 1225,
          "saleTime": "2017-12-12 21:57:30",
          "hotSale": 0,
          "disable": 0,
          "description": "",
          "orderNumber": "20171212215730",
          "readCount": 0,
          "stock": 1,
          "price3": 0,
          "productCode": "",
          "belongAreaId": 0,
          "belongShangquanId": 0,
          "belongShopId": 259,
          "belongAreaName": "",
          "belongShangquanName": "",
          "belongShopName": "水果分销",
          "tags": "",
          "promotion": "0",
          "platformNo": "shuiguofenxiao",
          "addTime": "2017-12-12 21:57:30",
          "minSaleCount": 1,
          "bigSmallUnitScale": 1,
          "tip": "",
          "unitShow": "个",
          "inCarCount": 0,
          "hgZhekou": 100,
          "lgZhekou": 100,
          "hzZhekou": 100,
          "lzZhekou": 100,
          "fxyZhekou": 100,
          "bdZhekou": 100,
          "categoryParent": 0,
          "categoryGradparent": 0,
          "newSale": 0,
          "brandId": 0,
          "commentCount": 0,
          "yunfei": 0,
          "yunfeiTemplate": 0,
          "productType": 0,
          "presalePrice": 0,
          "distributeProfit": 20,
          "daidingPlatformUserId": 0,
          "remark": "",
          "pingfen": 0,
          "pingfenCount": 0,
          "leaseUnitTypeStr": "小时",
          "productYear": "2017",
          "attributesCombind": "",
          "leaseUnitType": 0,
          "leaseUnitAmount": 0,
          "leaseUnitExpireAmount": 0,
          "leaseNeedBackUnitCount": 1,
          "measureItem": 0,
          "saleStrategyDetails": [

          ]
        }
      ]
    }