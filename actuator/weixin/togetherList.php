<!doctype html>
<html lang="zh-Hans">
 <head> 
  <meta charset="UTF-8"> 
  <title>买赠活动列表</title> 
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, viewport-fit=cover"> 
  <meta name="format-detection" content="telephone=no, email=no"> 
  <meta name="keywords" content="随心瑜微信约课,随心瑜瑜伽教练管理,随心瑜瑜伽课程,会员约课"> 
  <meta name="description" content="随心瑜云平台,随心瑜掌馆,随心瑜微信约课,轻松实现瑜伽馆经营管理及高速成长的一站式解决方案"> 
  <meta name="copyright" content="本页版权 keepyoga.com 随心瑜所有。All Rights Reserved"> 
  <link rel="stylesheet" href="css/reset.css?v=1cgbbap73"> 
  <link rel="stylesheet" href="css/style.css?v=1cgbbap73"> 
  <script>
    ! function(e, t) {
        function i() {
            var t = o.getBoundingClientRect().width;
            t / a > 750 && (t = 750 * a);
            var i = t / 10;
            o.style.fontSize = i + "px", d.rem = e.rem = i
        }
        var n, r = e.document,
            o = r.documentElement,
            a = (r.querySelector('meta[name="viewport"]'), r.querySelector('meta[name="flexible"]'), 0),
            d = t.flexible || (t.flexible = {});
        if (!a) {
            var l = (e.navigator.appVersion.match(/android/gi), e.navigator.appVersion.match(/iphone/gi)),
                m = e.devicePixelRatio;
            a = l ? m >= 3 && (!a || a >= 3) ? 3 : m >= 2 && (!a || a >= 2) ? 2 : 1 : 1
        }
        o.setAttribute("data-dpr", a), e.addEventListener("resize", function() {
            clearTimeout(n), n = setTimeout(i, 300)
        }, !1), e.addEventListener("pageshow", function(e) {
            e.persisted && (clearTimeout(n), n = setTimeout(i, 300))
        }, !1), i(), d.dpr = e.dpr = a, d.refreshRem = i
    }(window, window.lib || (window.lib = {}));
</script> 
  <link rel="stylesheet" type="text/css" href="css/together.css?v=1cgbbap73"> 
 </head> 
 <body> 
  <div class="main"> 
   <div class="main-content_cover ovya"> 
    <div class="together-list" id="dataList"></div> 
    <div class="copyright js-copyright">
      由
     <a class="copyright__link" id="website" href="https://m.keepyoga.com/static/register.php?agent=xYDud31519376479" target="_blank">随心瑜掌馆</a>提供技术支持 
    </div> 
   </div> 
  </div> 
  <!-- 秒杀活动列表模板 --> 
  <script type="text/tpl" id="tplDataList">
        <% if (cont.length == 0) { %>
            <div class="no-content">
                <img src="img/iconfont-xiaolian.svg?v=1cgbbap73">
            </div>
            <p class="text-center prompt-word">暂无活动信息</p>
        <% } else { %>
            <% for(var i=0;i<cont.length;i++){ %>
                <a class="together-list__item" href="cardDetailForTogether.php?brand_id=<%=brand_id %>&venue_id=<%=venue_id %>&id=<%=cont[i].id %>">
                    <div class="together-list__item-hd">
                        <span class="together-list__limit js-limit" id="limit_<%=cont[i].id %>" data-now="<%=cont[i].cur_time %>" data-start="<%=cont[i].start_time %>" data-end="<%=cont[i].end_time %>" data-id="<%=cont[i].id %>"></span>
                        <span class="together-list__status"><%=cont[i].status_ex_desc %></span>
                    </div>
                    <div class="together-list__item-bd">
                        <div class="together-list__img">
                            <img src="<%=cont[i].cover %>" alt="">
                        </div>
                        <div class="together-list__detail">
                            <div class="together-list__tit"><%=cont[i].name %></div>
                            <div class="together-list__nums"><%=cont[i].can_give_nums %>个赠送名额</div>
                        </div>
                    </div>
                    <div class="together-list__ft">
                        <div class="together-list__price"><span class="together-list__price-now"><span class="unit">¥</span><%=cont[i].activity_price %></span><span class="together-list__price-old">原价：¥<%=cont[i].price %></span></div>
                        <div class="together-list__btn">查看详情 <i class="together-list__btn-icon"></i></div>
                    </div>
                </a>
            <% } %>
        <% } %>
    </script> 
  <!-- /秒杀活动列表模板 --> 
  <!-- js --> 
  <script src="js/lib/jquery.min.js?v=static"></script> 
  <script src="js/lib/require.min.js?v=static"></script> 
  <script src="js/main.js?v=1cgbbap73"></script> 
  <!-- /js --> 
  <script>
    var ARGS = {
        brand_id: +APP.URISearch('brand_id') || 0,
        venue_id: +APP.URISearch('venue_id') || 0
    };

    if (ARGS.brand_id == 0) {
        window.location.href = 'errorInfo.php?url=' + window.location.href;
    }
</script> 
  <script>
    require(['fastclick', 'togetherList'], function(FastClick, togetherList) {
        //do something
        FastClick.attach(document.body);
    });
    </script> 
  <!-- 公告提示弹窗 --> 
  <div class="hide" id="announcementPrompt"> 
   <div class="shade"></div> 
   <div class="announcement-prompt"> 
    <img src="img/announcement.png?v=1cgbbap73"> 
    <p class="prompt" id="noticeTitle">您有<span></span>条新公告</p> 
    <svg> 
     <use xlink:href="img/icomoon.svg#icon-close"></use> 
    </svg> 
    <div class="info"> 
     <p class="title" id="announcementTitle"></p> 
     <p class="content" id="announcementContent"></p> 
     <a class="look" id="announcementLook" href="#">查看详情</a> 
    </div> 
   </div> 
  </div> 
  <!-- /公告提示弹窗 --> 
  <!-- CNZZ统计_vconsole --> 
  <div class="hide" id="sundry"></div> 
  <!-- /CNZZ统计_vconsole --> 
  <script>
    (function(global, env) {
        
        (env === 'production') && (function() {
            var sundry = document.getElementById('sundry');
            var cnzzNode = document.createElement('script');
            cnzzNode.src = '//s4.cnzz.com/z_stat.php?id=1260342201&web_id=1260342201';
            sundry.appendChild(cnzzNode);
        }());

    })(this, APP.ENVIRONMENT);
</script>  
 </body>
</html>