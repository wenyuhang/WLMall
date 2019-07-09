package com.wl.wlmall.model.entity;

import java.util.List;

/**
 * create by wyh on 2018/9/25
 * 果园列表
 */

public class NewsListBean {

    /**
     * msg : success
     * code : 0
     * data : {"total":125,"size":25,"pages":5,"current":2,"records":[{"id":23741,"userId":1260722,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc04574e5285890790194225814/05pEGXo7xWcA.mp4","title":"那个看起来最坚强的人，也有脆弱的时刻","uploadTime":"2019-06-12T10:20:18.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc04574e5285890790194225814/5285890790194225815.png","qqVideoId":"5285890790194225814","playNum":1635,"followNum":1431,"commentNum":52,"forwardNum":335,"duration":514,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"为梦出发","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/0C/rBK1slxSWzqAV5-MAAMtROuVCjY920.png","durationStr":"08'34\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["感悟短片"]},{"id":23740,"userId":1275004,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/be44954a5285890790194310392/fGCTcqAUJLIA.mp4","title":"魔芋没热量吃不胖？你可能想的太简单","uploadTime":"2019-06-12T10:20:05.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/be44954a5285890790194310392/5285890790194310393.png","qqVideoId":"5285890790194310392","playNum":6331,"followNum":804,"commentNum":48,"forwardNum":375,"duration":243,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"健康说","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/2B/rBK1slyTQKiAJErGAACSSfUm390678.jpg","durationStr":"04'03\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["养生饮食"]},{"id":23736,"userId":1261197,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b9f88c515285890790194167164/LA40adh5aGsA.mp4","title":"餐桌上的陌生人","uploadTime":"2019-06-12T10:19:02.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b9f88c515285890790194167164/5285890790194167165.png","qqVideoId":"5285890790194167164","playNum":498,"followNum":116,"commentNum":19,"forwardNum":40,"duration":653,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"奶脾木的爱情","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/12/rBK1slxmXfmACcv7AAA4l8enjb8179.jpg","durationStr":"10'53\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["婚姻"]},{"id":23754,"userId":1276394,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c56cb7bb5285890790194638837/hwoth1gFBvkA.mp4","title":"评测：6款最热门的纸尿裤，全方位评测！究竟哪款最好用？","uploadTime":"2019-06-12T10:28:24.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c56cb7bb5285890790194638837/5285890790194638838.png","qqVideoId":"5285890790194638837","playNum":7876,"followNum":822,"commentNum":36,"forwardNum":376,"duration":325,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"亲子趴","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/39/rBK1slzCyJGAZSFWAAVaxhDAon8135.png","durationStr":"05'25\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["母婴"]},{"id":23735,"userId":1276938,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c08b77d55285890790194407297/MHSgxANzXfsA.mp4","title":"办公室健身，每天10分钟，告别小肚腩！","uploadTime":"2019-06-12T10:18:52.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c08b77d55285890790194407297/5285890790194407298.png","qqVideoId":"5285890790194407297","playNum":4999,"followNum":105,"commentNum":14,"forwardNum":33,"duration":110,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"瘦身专家","avatar":"http://video.ldtch.com/FjzLTVGoLl-rtIamjD5uQKQ9AHiK","durationStr":"01'50\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["瑜伽美体"]},{"id":23720,"userId":1261288,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b98c96b45285890790194108568/UBEwkaQe1AkA.mp4","title":"理财扫盲课：两亿多人都会用的余X宝，后台到底是谁？","uploadTime":"2019-06-12T10:05:24.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b98c96b45285890790194108568/5285890790194108569.png","qqVideoId":"5285890790194108568","playNum":7168,"followNum":364,"commentNum":31,"forwardNum":83,"duration":89,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"知视视界","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/13/rBK1slxzhyCAH2NUAAl7IjXDB7o364.jpg","durationStr":"01'29\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["理财保险"]},{"id":23755,"userId":1277082,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c787b7ec5285890790194701651/AnLCWviFmvsA.mp4","title":"越吃越瘦超美味的：蜂蜜蒜香煎鸡胸，这样做最好吃！","uploadTime":"2019-06-12T10:28:29.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c787b7ec5285890790194701651/5285890790194701652.png","qqVideoId":"5285890790194701651","playNum":340,"followNum":677,"commentNum":13,"forwardNum":106,"duration":124,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"食语集","avatar":"http://video.ldtch.com/Fn0Dkbvbo3-qWoh6JmCdeUtveiTD","durationStr":"02'04\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["美食厨艺"]},{"id":22340,"userId":1261231,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0c7126565285890789420125967/ozuF3i6sE64A.mp4","title":"带你花钱，我买的神仙春夏口红完全不踩雷！","uploadTime":"2019-05-23T10:26:08.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0c7126565285890789420125967/5285890789420125968.png","qqVideoId":"5285890789420125967","playNum":460,"followNum":1422,"commentNum":38,"forwardNum":444,"duration":730,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"好物推荐","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/13/rBK1slxrmdeAOKiWAAE0NpKt2vs211.jpg","durationStr":"12'10\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["好物"]},{"id":22335,"userId":1260534,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0a51a4ec5285890789420054416/WaOGZTkajcYA.mp4","title":"超级适合学生党的衬衫搭配合辑","uploadTime":"2019-05-23T10:23:40.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0a51a4ec5285890789420054416/5285890789420054417.png","qqVideoId":"5285890789420054416","playNum":1287,"followNum":1046,"commentNum":35,"forwardNum":311,"duration":396,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"Wear and ride","avatar":"http://qiniulive2.llsxl.cn/20181218_5c186eaf35f72.jpeg","durationStr":"06'36\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["穿搭"]},{"id":22524,"userId":1276938,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/7fd698e95285890789490015211/xyxg1bU0Q4gA.mp4","title":"生理期时做这4组动作，缓解痛经调气血！","uploadTime":"2019-05-25T09:19:54.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/7fd698e95285890789490015211/5285890789490015212.png","qqVideoId":"5285890789490015211","playNum":5117,"followNum":1462,"commentNum":40,"forwardNum":593,"duration":78,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"瘦身专家","avatar":"http://video.ldtch.com/FjzLTVGoLl-rtIamjD5uQKQ9AHiK","durationStr":"01'18\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["瑜伽美体"]},{"id":22621,"userId":1276644,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7a56aba5285890789565343374/9x8xkSJvSBcA.mp4","title":"【美颜向】阳光沙滩海浪~夏天美好三部曲","uploadTime":"2019-05-27T09:51:03.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7a56aba5285890789565343374/5285890789565343375.png","qqVideoId":"5285890789565343374","playNum":3857,"followNum":1130,"commentNum":20,"forwardNum":298,"duration":204,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"国际model","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/3C/rBK1slzIFfeAR-YTAACH6vvwWjI623.jpg","durationStr":"03'24\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["时尚风向"]},{"id":23306,"userId":1277097,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c3c556ed5285890789911801070/l1PPGd4yv08A.mp4","title":"每天五分钟！告别胸部下垂","uploadTime":"2019-06-05T07:32:30.000+0000","city":null,"coverUrl":"http://video.ldtch.com/Ft4VzgSUFU0y-zR-DJ6dpYyheHpY","qqVideoId":"5285890789911801070","playNum":898,"followNum":1291,"commentNum":26,"forwardNum":57,"duration":387,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"柚子","avatar":"http://video.ldtch.com/FnS4p9PLnohMNWuLciAImfjtyxiB","durationStr":"06'27\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["美胸内搭"]},{"id":22993,"userId":1276938,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/2538a95a5285890789705967420/D9gfPkSvGYQA.mp4","title":"超简单的瑜伽串联 ，提臀瘦腿适合初学小白","uploadTime":"2019-05-31T10:19:25.000+0000","city":null,"coverUrl":"http://video.ldtch.com/FnIh_dwMXQmEa7JdCLRNQLbZ6RjJ","qqVideoId":"5285890789705967420","playNum":1024,"followNum":1122,"commentNum":12,"forwardNum":173,"duration":237,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"瘦身专家","avatar":"http://video.ldtch.com/FjzLTVGoLl-rtIamjD5uQKQ9AHiK","durationStr":"03'57\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["瑜伽美体"]},{"id":22625,"userId":1276736,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7cb4d215285890789565366637/mTfCVtAU7yYA.mp4","title":"散粉和粉饼的区别？具体使用的步骤？","uploadTime":"2019-05-27T09:52:32.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7cb4d215285890789565366637/5285890789565366638.png","qqVideoId":"5285890789565366637","playNum":2176,"followNum":1066,"commentNum":29,"forwardNum":87,"duration":355,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"细细爱美","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/3D/rBK1slzT_7iAdheMAADJZB82l9c562.jpg","durationStr":"05'55\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["好物"]},{"id":23120,"userId":1271834,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e504105c5285890789813669324/7gOqIQPqAiwA.mp4","title":"引体向上入门及进阶（背部训练必备）","uploadTime":"2019-06-03T09:56:54.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e504105c5285890789813669324/5285890789813669325.png","qqVideoId":"5285890789813669324","playNum":2840,"followNum":969,"commentNum":23,"forwardNum":427,"duration":309,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"助人使我快乐","avatar":"http://qiniulive2.llsxl.cn/20181009102959_051454b81f82e7d873b3acd3db9d5fe9?imageView2/2/w/600/h/600","durationStr":"05'09\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["健身减脂"]},{"id":23118,"userId":1260746,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e502741b5285890789813666551/dX3SBzNPmRwA.mp4","title":"喝果汁等于吃水果？其实你得到的是一杯糖水","uploadTime":"2019-06-03T09:54:56.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e502741b5285890789813666551/5285890789813666552.png","qqVideoId":"5285890789813666551","playNum":9078,"followNum":293,"commentNum":46,"forwardNum":123,"duration":121,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"健康大包围","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/0C/rBK1slxSZGqADdH5AAEHPpjvEAY48.jpeg","durationStr":"02'01\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["健康知识"]},{"id":23121,"userId":1273094,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e5004f9b5285890789813662870/q7flWQ9wRfsA.mp4","title":"我的一日三餐食谱公开！这样吃不健康瘦才怪！","uploadTime":"2019-06-03T09:56:54.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e5004f9b5285890789813662870/5285890789813662871.png","qqVideoId":"5285890789813662870","playNum":3792,"followNum":684,"commentNum":61,"forwardNum":128,"duration":185,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"安安。","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/19/rBK1slyCIJ6AFN-gAAHn2FL9WWc658.jpg","durationStr":"03'05\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["养生饮食"]},{"id":22240,"userId":1261302,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/8e66bdbc5285890789388382325/ApFKMOMsxdoA.mp4","title":"儿童教育专家解读：如何应对孩子的叛逆期？","uploadTime":"2019-05-22T09:55:20.000+0000","city":null,"coverUrl":"http://video.ldtch.com/Fu6IzD4ZHZ8Blu0WJabdvNNJZLTg","qqVideoId":"5285890789388382325","playNum":7871,"followNum":886,"commentNum":14,"forwardNum":272,"duration":215,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"孩儿事","avatar":"http://video.ldtch.com/FvgV0Kzk83ObfT5hgwvQJTsRiQnx","durationStr":"03'35\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["教育理念"]},{"id":21895,"userId":1276632,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bb5ea8b75285890789083834434/seQfVEPh0QkA.mp4","title":"孩子尿床难纠正，因为你是\u201c仆人式妈妈\u201d","uploadTime":"2019-05-14T10:04:19.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bb5ea8b75285890789083834434/5285890789083834435.png","qqVideoId":"5285890789083834434","playNum":7759,"followNum":1065,"commentNum":23,"forwardNum":129,"duration":99,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"杨帆","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/3C/rBK1slzH9BWAbN8WAAGcLauRAA4398.png","durationStr":"01'39\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["育儿方法"]},{"id":22526,"userId":1261288,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/821a4ff95285890789490106892/Vv8xSl9Rj3cA.mp4","title":"宝宝到底啥时候断奶？小心错误的断奶方式！","uploadTime":"2019-05-25T09:21:40.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/821a4ff95285890789490106892/5285890789490106893.png","qqVideoId":"5285890789490106892","playNum":2086,"followNum":1260,"commentNum":9,"forwardNum":497,"duration":147,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"知视视界","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/13/rBK1slxzhyCAH2NUAAl7IjXDB7o364.jpg","durationStr":"02'27\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["母婴"]},{"id":22519,"userId":1260540,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/5b51fe425285890789489854190/gjleCVysHHAA.mp4","title":"【芝士年糕辣鸡】一份充满一切幻想的食物","uploadTime":"2019-05-25T09:15:01.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/5b51fe425285890789489854190/5285890789489854192.png","qqVideoId":"5285890789489854190","playNum":5162,"followNum":1353,"commentNum":57,"forwardNum":223,"duration":224,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"food","avatar":"http://qiniulive2.llsxl.cn/20181219_5c1a09f09a327.jpg","durationStr":"03'44\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["网红甜点"]},{"id":22801,"userId":1276974,"videoUrl":"http://video.ldtch.com/llnAZ-5KFuvZEXsqipvc78WmO4Wq.m3u8?videoType=m3u8","title":"超详细万能酥皮教程来了-自制蛋挞","uploadTime":"2019-05-29T09:34:10.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b2362f225285890789636270978/5285890789636270979.png","qqVideoId":"llnAZ-5KFuvZEXsqipvc78WmO4Wq","playNum":4529,"followNum":792,"commentNum":17,"forwardNum":28,"duration":221,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"烤乐仕","avatar":"http://video.ldtch.com/Ft3mme_ZPr912H0_97g9y6tFltX8","durationStr":"03'41\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["网红甜点"]},{"id":22704,"userId":1276979,"videoUrl":"http://video.ldtch.com/lg5SqUZw1vkSvj_97PMKBJzYAbdp.m3u8?videoType=m3u8","title":"保鲜膜的妙用这么多，你知道几个？","uploadTime":"2019-05-28T09:41:37.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/7c6509705285890789601904361/5285890789601904362.png","qqVideoId":"lg5SqUZw1vkSvj_97PMKBJzYAbdp","playNum":5665,"followNum":1508,"commentNum":10,"forwardNum":514,"duration":104,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"乐活","avatar":"http://video.ldtch.com/FlxSingKbIFN8yRepYczbPHZC2Gj","durationStr":"01'44\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["居家妙招"]},{"id":22239,"userId":1276394,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/8e3188785285890789388354205/OiSATka2pk8A.mp4","title":"宝宝发烧了如何处理？常用的家庭护理方法","uploadTime":"2019-05-22T09:54:39.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/8e3188785285890789388354205/5285890789388354206.png","qqVideoId":"5285890789388354205","playNum":7870,"followNum":418,"commentNum":9,"forwardNum":103,"duration":100,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"亲子趴","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/39/rBK1slzCyJGAZSFWAAVaxhDAon8135.png","durationStr":"01'40\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["母婴"]},{"id":22626,"userId":1260742,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc09a5055285890789565507977/saEs9MGtGg4A.mp4","title":"孩子睡梦中妙语连珠？儿童梦话到底咋回事？","uploadTime":"2019-05-27T09:56:56.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc09a5055285890789565507977/5285890789565507978.png","qqVideoId":"5285890789565507977","playNum":780,"followNum":582,"commentNum":34,"forwardNum":165,"duration":123,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"焦糖猫育儿","avatar":"http://video.ldtch.com/FveRtgFfRIFVkvcZzHLx1PVgNgZn","durationStr":"02'03\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["育儿方法"]}]}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 125
         * size : 25
         * pages : 5
         * current : 2
         * records : [{"id":23741,"userId":1260722,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc04574e5285890790194225814/05pEGXo7xWcA.mp4","title":"那个看起来最坚强的人，也有脆弱的时刻","uploadTime":"2019-06-12T10:20:18.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc04574e5285890790194225814/5285890790194225815.png","qqVideoId":"5285890790194225814","playNum":1635,"followNum":1431,"commentNum":52,"forwardNum":335,"duration":514,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"为梦出发","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/0C/rBK1slxSWzqAV5-MAAMtROuVCjY920.png","durationStr":"08'34\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["感悟短片"]},{"id":23740,"userId":1275004,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/be44954a5285890790194310392/fGCTcqAUJLIA.mp4","title":"魔芋没热量吃不胖？你可能想的太简单","uploadTime":"2019-06-12T10:20:05.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/be44954a5285890790194310392/5285890790194310393.png","qqVideoId":"5285890790194310392","playNum":6331,"followNum":804,"commentNum":48,"forwardNum":375,"duration":243,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"健康说","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/2B/rBK1slyTQKiAJErGAACSSfUm390678.jpg","durationStr":"04'03\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["养生饮食"]},{"id":23736,"userId":1261197,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b9f88c515285890790194167164/LA40adh5aGsA.mp4","title":"餐桌上的陌生人","uploadTime":"2019-06-12T10:19:02.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b9f88c515285890790194167164/5285890790194167165.png","qqVideoId":"5285890790194167164","playNum":498,"followNum":116,"commentNum":19,"forwardNum":40,"duration":653,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"奶脾木的爱情","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/12/rBK1slxmXfmACcv7AAA4l8enjb8179.jpg","durationStr":"10'53\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["婚姻"]},{"id":23754,"userId":1276394,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c56cb7bb5285890790194638837/hwoth1gFBvkA.mp4","title":"评测：6款最热门的纸尿裤，全方位评测！究竟哪款最好用？","uploadTime":"2019-06-12T10:28:24.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c56cb7bb5285890790194638837/5285890790194638838.png","qqVideoId":"5285890790194638837","playNum":7876,"followNum":822,"commentNum":36,"forwardNum":376,"duration":325,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"亲子趴","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/39/rBK1slzCyJGAZSFWAAVaxhDAon8135.png","durationStr":"05'25\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["母婴"]},{"id":23735,"userId":1276938,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c08b77d55285890790194407297/MHSgxANzXfsA.mp4","title":"办公室健身，每天10分钟，告别小肚腩！","uploadTime":"2019-06-12T10:18:52.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c08b77d55285890790194407297/5285890790194407298.png","qqVideoId":"5285890790194407297","playNum":4999,"followNum":105,"commentNum":14,"forwardNum":33,"duration":110,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"瘦身专家","avatar":"http://video.ldtch.com/FjzLTVGoLl-rtIamjD5uQKQ9AHiK","durationStr":"01'50\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["瑜伽美体"]},{"id":23720,"userId":1261288,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b98c96b45285890790194108568/UBEwkaQe1AkA.mp4","title":"理财扫盲课：两亿多人都会用的余X宝，后台到底是谁？","uploadTime":"2019-06-12T10:05:24.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b98c96b45285890790194108568/5285890790194108569.png","qqVideoId":"5285890790194108568","playNum":7168,"followNum":364,"commentNum":31,"forwardNum":83,"duration":89,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"知视视界","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/13/rBK1slxzhyCAH2NUAAl7IjXDB7o364.jpg","durationStr":"01'29\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["理财保险"]},{"id":23755,"userId":1277082,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c787b7ec5285890790194701651/AnLCWviFmvsA.mp4","title":"越吃越瘦超美味的：蜂蜜蒜香煎鸡胸，这样做最好吃！","uploadTime":"2019-06-12T10:28:29.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c787b7ec5285890790194701651/5285890790194701652.png","qqVideoId":"5285890790194701651","playNum":340,"followNum":677,"commentNum":13,"forwardNum":106,"duration":124,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"食语集","avatar":"http://video.ldtch.com/Fn0Dkbvbo3-qWoh6JmCdeUtveiTD","durationStr":"02'04\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["美食厨艺"]},{"id":22340,"userId":1261231,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0c7126565285890789420125967/ozuF3i6sE64A.mp4","title":"带你花钱，我买的神仙春夏口红完全不踩雷！","uploadTime":"2019-05-23T10:26:08.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0c7126565285890789420125967/5285890789420125968.png","qqVideoId":"5285890789420125967","playNum":460,"followNum":1422,"commentNum":38,"forwardNum":444,"duration":730,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"好物推荐","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/13/rBK1slxrmdeAOKiWAAE0NpKt2vs211.jpg","durationStr":"12'10\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["好物"]},{"id":22335,"userId":1260534,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0a51a4ec5285890789420054416/WaOGZTkajcYA.mp4","title":"超级适合学生党的衬衫搭配合辑","uploadTime":"2019-05-23T10:23:40.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/0a51a4ec5285890789420054416/5285890789420054417.png","qqVideoId":"5285890789420054416","playNum":1287,"followNum":1046,"commentNum":35,"forwardNum":311,"duration":396,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"Wear and ride","avatar":"http://qiniulive2.llsxl.cn/20181218_5c186eaf35f72.jpeg","durationStr":"06'36\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["穿搭"]},{"id":22524,"userId":1276938,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/7fd698e95285890789490015211/xyxg1bU0Q4gA.mp4","title":"生理期时做这4组动作，缓解痛经调气血！","uploadTime":"2019-05-25T09:19:54.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/7fd698e95285890789490015211/5285890789490015212.png","qqVideoId":"5285890789490015211","playNum":5117,"followNum":1462,"commentNum":40,"forwardNum":593,"duration":78,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"瘦身专家","avatar":"http://video.ldtch.com/FjzLTVGoLl-rtIamjD5uQKQ9AHiK","durationStr":"01'18\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["瑜伽美体"]},{"id":22621,"userId":1276644,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7a56aba5285890789565343374/9x8xkSJvSBcA.mp4","title":"【美颜向】阳光沙滩海浪~夏天美好三部曲","uploadTime":"2019-05-27T09:51:03.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7a56aba5285890789565343374/5285890789565343375.png","qqVideoId":"5285890789565343374","playNum":3857,"followNum":1130,"commentNum":20,"forwardNum":298,"duration":204,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"国际model","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/3C/rBK1slzIFfeAR-YTAACH6vvwWjI623.jpg","durationStr":"03'24\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["时尚风向"]},{"id":23306,"userId":1277097,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/c3c556ed5285890789911801070/l1PPGd4yv08A.mp4","title":"每天五分钟！告别胸部下垂","uploadTime":"2019-06-05T07:32:30.000+0000","city":null,"coverUrl":"http://video.ldtch.com/Ft4VzgSUFU0y-zR-DJ6dpYyheHpY","qqVideoId":"5285890789911801070","playNum":898,"followNum":1291,"commentNum":26,"forwardNum":57,"duration":387,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"柚子","avatar":"http://video.ldtch.com/FnS4p9PLnohMNWuLciAImfjtyxiB","durationStr":"06'27\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["美胸内搭"]},{"id":22993,"userId":1276938,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/2538a95a5285890789705967420/D9gfPkSvGYQA.mp4","title":"超简单的瑜伽串联 ，提臀瘦腿适合初学小白","uploadTime":"2019-05-31T10:19:25.000+0000","city":null,"coverUrl":"http://video.ldtch.com/FnIh_dwMXQmEa7JdCLRNQLbZ6RjJ","qqVideoId":"5285890789705967420","playNum":1024,"followNum":1122,"commentNum":12,"forwardNum":173,"duration":237,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"瘦身专家","avatar":"http://video.ldtch.com/FjzLTVGoLl-rtIamjD5uQKQ9AHiK","durationStr":"03'57\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["瑜伽美体"]},{"id":22625,"userId":1276736,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7cb4d215285890789565366637/mTfCVtAU7yYA.mp4","title":"散粉和粉饼的区别？具体使用的步骤？","uploadTime":"2019-05-27T09:52:32.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b7cb4d215285890789565366637/5285890789565366638.png","qqVideoId":"5285890789565366637","playNum":2176,"followNum":1066,"commentNum":29,"forwardNum":87,"duration":355,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"细细爱美","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/3D/rBK1slzT_7iAdheMAADJZB82l9c562.jpg","durationStr":"05'55\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["好物"]},{"id":23120,"userId":1271834,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e504105c5285890789813669324/7gOqIQPqAiwA.mp4","title":"引体向上入门及进阶（背部训练必备）","uploadTime":"2019-06-03T09:56:54.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e504105c5285890789813669324/5285890789813669325.png","qqVideoId":"5285890789813669324","playNum":2840,"followNum":969,"commentNum":23,"forwardNum":427,"duration":309,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"助人使我快乐","avatar":"http://qiniulive2.llsxl.cn/20181009102959_051454b81f82e7d873b3acd3db9d5fe9?imageView2/2/w/600/h/600","durationStr":"05'09\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["健身减脂"]},{"id":23118,"userId":1260746,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e502741b5285890789813666551/dX3SBzNPmRwA.mp4","title":"喝果汁等于吃水果？其实你得到的是一杯糖水","uploadTime":"2019-06-03T09:54:56.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e502741b5285890789813666551/5285890789813666552.png","qqVideoId":"5285890789813666551","playNum":9078,"followNum":293,"commentNum":46,"forwardNum":123,"duration":121,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"健康大包围","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/0C/rBK1slxSZGqADdH5AAEHPpjvEAY48.jpeg","durationStr":"02'01\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["健康知识"]},{"id":23121,"userId":1273094,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e5004f9b5285890789813662870/q7flWQ9wRfsA.mp4","title":"我的一日三餐食谱公开！这样吃不健康瘦才怪！","uploadTime":"2019-06-03T09:56:54.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/e5004f9b5285890789813662870/5285890789813662871.png","qqVideoId":"5285890789813662870","playNum":3792,"followNum":684,"commentNum":61,"forwardNum":128,"duration":185,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"安安。","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/19/rBK1slyCIJ6AFN-gAAHn2FL9WWc658.jpg","durationStr":"03'05\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["养生饮食"]},{"id":22240,"userId":1261302,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/8e66bdbc5285890789388382325/ApFKMOMsxdoA.mp4","title":"儿童教育专家解读：如何应对孩子的叛逆期？","uploadTime":"2019-05-22T09:55:20.000+0000","city":null,"coverUrl":"http://video.ldtch.com/Fu6IzD4ZHZ8Blu0WJabdvNNJZLTg","qqVideoId":"5285890789388382325","playNum":7871,"followNum":886,"commentNum":14,"forwardNum":272,"duration":215,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"孩儿事","avatar":"http://video.ldtch.com/FvgV0Kzk83ObfT5hgwvQJTsRiQnx","durationStr":"03'35\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["教育理念"]},{"id":21895,"userId":1276632,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bb5ea8b75285890789083834434/seQfVEPh0QkA.mp4","title":"孩子尿床难纠正，因为你是\u201c仆人式妈妈\u201d","uploadTime":"2019-05-14T10:04:19.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bb5ea8b75285890789083834434/5285890789083834435.png","qqVideoId":"5285890789083834434","playNum":7759,"followNum":1065,"commentNum":23,"forwardNum":129,"duration":99,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"杨帆","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/3C/rBK1slzH9BWAbN8WAAGcLauRAA4398.png","durationStr":"01'39\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["育儿方法"]},{"id":22526,"userId":1261288,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/821a4ff95285890789490106892/Vv8xSl9Rj3cA.mp4","title":"宝宝到底啥时候断奶？小心错误的断奶方式！","uploadTime":"2019-05-25T09:21:40.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/821a4ff95285890789490106892/5285890789490106893.png","qqVideoId":"5285890789490106892","playNum":2086,"followNum":1260,"commentNum":9,"forwardNum":497,"duration":147,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"知视视界","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/13/rBK1slxzhyCAH2NUAAl7IjXDB7o364.jpg","durationStr":"02'27\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["母婴"]},{"id":22519,"userId":1260540,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/5b51fe425285890789489854190/gjleCVysHHAA.mp4","title":"【芝士年糕辣鸡】一份充满一切幻想的食物","uploadTime":"2019-05-25T09:15:01.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/5b51fe425285890789489854190/5285890789489854192.png","qqVideoId":"5285890789489854190","playNum":5162,"followNum":1353,"commentNum":57,"forwardNum":223,"duration":224,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"food","avatar":"http://qiniulive2.llsxl.cn/20181219_5c1a09f09a327.jpg","durationStr":"03'44\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["网红甜点"]},{"id":22801,"userId":1276974,"videoUrl":"http://video.ldtch.com/llnAZ-5KFuvZEXsqipvc78WmO4Wq.m3u8?videoType=m3u8","title":"超详细万能酥皮教程来了-自制蛋挞","uploadTime":"2019-05-29T09:34:10.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/b2362f225285890789636270978/5285890789636270979.png","qqVideoId":"llnAZ-5KFuvZEXsqipvc78WmO4Wq","playNum":4529,"followNum":792,"commentNum":17,"forwardNum":28,"duration":221,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"烤乐仕","avatar":"http://video.ldtch.com/Ft3mme_ZPr912H0_97g9y6tFltX8","durationStr":"03'41\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["网红甜点"]},{"id":22704,"userId":1276979,"videoUrl":"http://video.ldtch.com/lg5SqUZw1vkSvj_97PMKBJzYAbdp.m3u8?videoType=m3u8","title":"保鲜膜的妙用这么多，你知道几个？","uploadTime":"2019-05-28T09:41:37.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/7c6509705285890789601904361/5285890789601904362.png","qqVideoId":"lg5SqUZw1vkSvj_97PMKBJzYAbdp","playNum":5665,"followNum":1508,"commentNum":10,"forwardNum":514,"duration":104,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"乐活","avatar":"http://video.ldtch.com/FlxSingKbIFN8yRepYczbPHZC2Gj","durationStr":"01'44\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["居家妙招"]},{"id":22239,"userId":1276394,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/8e3188785285890789388354205/OiSATka2pk8A.mp4","title":"宝宝发烧了如何处理？常用的家庭护理方法","uploadTime":"2019-05-22T09:54:39.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/8e3188785285890789388354205/5285890789388354206.png","qqVideoId":"5285890789388354205","playNum":7870,"followNum":418,"commentNum":9,"forwardNum":103,"duration":100,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"亲子趴","avatar":"http://gxt.ldtch.com/gx/fs/group1/M00/00/39/rBK1slzCyJGAZSFWAAVaxhDAon8135.png","durationStr":"01'40\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["母婴"]},{"id":22626,"userId":1260742,"videoUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc09a5055285890789565507977/saEs9MGtGg4A.mp4","title":"孩子睡梦中妙语连珠？儿童梦话到底咋回事？","uploadTime":"2019-05-27T09:56:56.000+0000","city":null,"coverUrl":"http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc09a5055285890789565507977/5285890789565507978.png","qqVideoId":"5285890789565507977","playNum":780,"followNum":582,"commentNum":34,"forwardNum":165,"duration":123,"videoSpecialColumnId":null,"isAcross":1,"size":null,"nickname":"焦糖猫育儿","avatar":"http://video.ldtch.com/FveRtgFfRIFVkvcZzHLx1PVgNgZn","durationStr":"02'03\"","isFollow":0,"isAttention":0,"columnType":null,"highLightTitle":null,"labels":["育儿方法"]}]
         */

        private int total;
        private int size;
        private int pages;
        private int current;
        private List<RecordsBean> records;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * id : 23741
             * userId : 1260722
             * videoUrl : http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc04574e5285890790194225814/05pEGXo7xWcA.mp4
             * title : 那个看起来最坚强的人，也有脆弱的时刻
             * uploadTime : 2019-06-12T10:20:18.000+0000
             * city : null
             * coverUrl : http://1257284782.vod2.myqcloud.com/5d8d682dvodgzp1257284782/bc04574e5285890790194225814/5285890790194225815.png
             * qqVideoId : 5285890790194225814
             * playNum : 1635
             * followNum : 1431
             * commentNum : 52
             * forwardNum : 335
             * duration : 514
             * videoSpecialColumnId : null
             * isAcross : 1
             * size : null
             * nickname : 为梦出发
             * avatar : http://gxt.ldtch.com/gx/fs/group1/M00/00/0C/rBK1slxSWzqAV5-MAAMtROuVCjY920.png
             * durationStr : 08'34"
             * isFollow : 0
             * isAttention : 0
             * columnType : null
             * highLightTitle : null
             * labels : ["感悟短片"]
             */

            private int id;
            private int userId;
            private String videoUrl;
            private String title;
            private String uploadTime;
            private Object city;
            private String coverUrl;
            private String qqVideoId;
            private int playNum;
            private int followNum;
            private int commentNum;
            private int forwardNum;
            private int duration;
            private Object videoSpecialColumnId;
            private int isAcross;
            private Object size;
            private String nickname;
            private String avatar;
            private String durationStr;
            private int isFollow;
            private int isAttention;
            private Object columnType;
            private Object highLightTitle;
            private List<String> labels;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUploadTime() {
                return uploadTime;
            }

            public void setUploadTime(String uploadTime) {
                this.uploadTime = uploadTime;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public String getQqVideoId() {
                return qqVideoId;
            }

            public void setQqVideoId(String qqVideoId) {
                this.qqVideoId = qqVideoId;
            }

            public int getPlayNum() {
                return playNum;
            }

            public void setPlayNum(int playNum) {
                this.playNum = playNum;
            }

            public int getFollowNum() {
                return followNum;
            }

            public void setFollowNum(int followNum) {
                this.followNum = followNum;
            }

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public int getForwardNum() {
                return forwardNum;
            }

            public void setForwardNum(int forwardNum) {
                this.forwardNum = forwardNum;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public Object getVideoSpecialColumnId() {
                return videoSpecialColumnId;
            }

            public void setVideoSpecialColumnId(Object videoSpecialColumnId) {
                this.videoSpecialColumnId = videoSpecialColumnId;
            }

            public int getIsAcross() {
                return isAcross;
            }

            public void setIsAcross(int isAcross) {
                this.isAcross = isAcross;
            }

            public Object getSize() {
                return size;
            }

            public void setSize(Object size) {
                this.size = size;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getDurationStr() {
                return durationStr;
            }

            public void setDurationStr(String durationStr) {
                this.durationStr = durationStr;
            }

            public int getIsFollow() {
                return isFollow;
            }

            public void setIsFollow(int isFollow) {
                this.isFollow = isFollow;
            }

            public int getIsAttention() {
                return isAttention;
            }

            public void setIsAttention(int isAttention) {
                this.isAttention = isAttention;
            }

            public Object getColumnType() {
                return columnType;
            }

            public void setColumnType(Object columnType) {
                this.columnType = columnType;
            }

            public Object getHighLightTitle() {
                return highLightTitle;
            }

            public void setHighLightTitle(Object highLightTitle) {
                this.highLightTitle = highLightTitle;
            }

            public List<String> getLabels() {
                return labels;
            }

            public void setLabels(List<String> labels) {
                this.labels = labels;
            }
        }
    }
}
