<!doctype html>
<html lang="zh-Hans">
 <head> 
  <meta charset="UTF-8"> 
  <title>已约课程</title> 
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
  <link rel="stylesheet" type="text/css" href="css/learnRecord.css?v=1cgbbap73"> 
 </head> 
 <body> 
  <div class="main"> 
   <div class="learnRecord-status" id="learnRecordStatus"> 
    <div class="learnRecord__item"> 
     <span class="learnRecord__text learnRecord__text_curr">已预约</span> 
    </div> 
    <div class="learnRecord__item"> 
     <span class="learnRecord__text">已签到</span> 
    </div> 
    <div class="learnRecord__item"> 
     <span class="learnRecord__text">已取消</span> 
    </div> 
   </div> 
   <div class="learnRecord-layout ovya" id="J_Container"> 
    <div class="learnRecord-box" id="J_LearnRecord"></div> 
    <div class="copyright js-copyright">
      由
     <a class="copyright__link" id="website" href="https://m.keepyoga.com/static/register.php?agent=xYDud31519376479" target="_blank">随心瑜掌馆</a>提供技术支持 
    </div> 
   </div> 
   <div class="footer-menu" id="footer"> 
    <a href="venue.php?brand_id=5996&amp;venue_id=1" class="footer-menu__btn">场馆</a> 
    <a href="leagueSyllabus.php?brand_id=5996&amp;venue_id=1" class="footer-menu__btn">约课</a> 
    <a href="learnRecord.php?brand_id=5996&amp;venue_id=1" class="footer-menu__btn">已约</a> 
    <a href="my.php?brand_id=5996&amp;venue_id=1&amp;type=cards" class="footer-menu__btn">我的</a> 
   </div> 
  </div> 
  <!-- 确认弹窗 --> 
  <div class="js-dialog hide" id="J_Dialog"> 
   <div class="popup-bg"></div> 
   <div class="popup-confirm"> 
    <div class="popup__bd js-type">
     确认签到吗？
    </div> 
    <div class="popup__btn-group"> 
     <span class="popup__btn popup__btn_sure" id="J_Sure">确认</span> 
     <span class="popup__btn popup__btn_cancel" id="J_Cancel">取消</span> 
    </div> 
   </div> 
  </div> 
  <!-- /确认弹窗 --> 
  <!-- 已约课程模板 --> 
  <script type="text/tpl" id="TplRecord">
        <% if (cont.length == 0) { %>
            <div class="no-content">
                <img src="img/iconfont-xiaolian.svg?v=1cgbbap73">
            </div>
            <p class="text-center prompt-word">无约课信息</p>
            <a class="btn-to-order" id="goToOrder" href="leagueSyllabus.php?brand_id=5996&venue_id=1">马上去约课</a>
        <% } else { %>
                <% for(var i=0;i<cont.length;i++){ %>
                    <div class="item">
                        <div class="class-title">
                            <span class="make-class-middle">
                                <span class="class-name"><%=cont[i].course_name %></span>
                                <span class="class-<%=(cont[i].course_type== 2 ? 'private' : 'group' )%>"><%=cont[i].course_type_name %></span>
                            </span>                            
                            <% if(cont[i].can_cancel == 1) { %>
                                <span class="make-register-middle cancel" data-rid="<%=cont[i].id%>">
                                    <button class="register-cancel">取消</button>
                                </span>
                            <% } %>
                            <% if(cont[i].can_sign == 1) { %>
                                <span class="make-register-middle sign" data-rid="<%=cont[i].id%>">
                                    <button class="register">签到</button>
                                </span>
                            <% } %>
                            <% if(cont[i].can_seat_selection == 1) { %>
                            <span class="make-register-middle choose-seat" data-sid="<%=cont[i].schedule_id %>" data-rid="<%=cont[i].id %>">
                                <button class="register">选座</button>
                            </span>
                            <% } %>
                            <% if(cont[i].course_type == 1 && cont[i].can_evaluate == 1) { %>
                            <span class="make-register-middle js-commet" data-sid="<%=cont[i].schedule_id %>" data-rid="<%=cont[i].id %>" data-cname="<%=cont[i].course_name %>" data-coach="<%=cont[i].coach_name %>">
                                <button class="btn-comment">评价</button>
                            </span>
                            <% } %>
                            <% if(cont[i].can_evaluate == 2) { %>
                            <span class="make-register-middle js-commet-complete" data-eid="<%=cont[i].evaluate_id %>">
                                <button class="btn-comment-complete">已评价</button>
                            </span>
                            <% } %>
                            <% if(cont[i].can_sign == 0 && cont[i].can_cancel == 0) { %>
                                <span class="make-register-middle">
                                    <span class="<%=(cont[i].status == '2' ? 'register-already' : '' )%>"><%=cont[i].status_desc %></span>
                                </span>
                            <% } %>
                        </div>
                        <ul class="detail-list">
                            <li class="<%=(show_level=='1'?'':'hide')%>">
                                <span class="title col-3">课程难度</span>
                                <span class="content">
                                    <%for(var j=0;j<cont[i].course_diff_level;j++){%>
                                        <img src="img/shallow-orange-star.svg?v=1cgbbap73">
                                    <%}%>
                                    <%for(var j=0;j<(5-cont[i].course_diff_level);j++){%>
                                        <img src="img/shallow-white-star.svg?v=1cgbbap73">
                                    <%}%>
                                </span>
                            </li>
                            <li>
                                <span class="title col-3">上课时间</span>
                                <span class="content"><%=cont[i].date %>(<%=cont[i].week_day %>)  <%=cont[i].start %>~<%=cont[i].end %></span>                                
                            </li>
                            <%
                                if(cont[i].can_seat_selection != -1){
                            %>
                            <li><span class="title col-3">座位</span><span class="content"><%=#seatInfo(cont[i].seat,cont[i].schedule_id) %></span></li>
                            <%
                                }
                            %>
                            <li><span class="title col-3">教练</span><span class="content"><%=cont[i].coach_name %></span></li>
                            <li><span class="title col-3">上课场馆</span><span class="content"><%=cont[i].venue_name %></span></li>
                            <%
                            if(cont[i].single_charge){
                            %>
                            <li><span class="title col-3">扣费</span><span class="content"><%=cont[i].single_charge %></span></li>
                            <%
                            }
                            %>
                            <li><span class="title col-3">上课教室</span><span class="content"><%=(cont[i].classroom == ''?'不指定': cont[i].classroom)%></span></li>
                            <li><span class="title col-3">场馆电话</span>
                                <a href="tel:<%=cont[i].venue_telephone ? cont[i].venue_telephone : cont[i].venue_mobile %>" class="content highlight-tel">
                                    <%=cont[i].venue_telephone ? cont[i].venue_telephone : cont[i].venue_mobile %>
                                </a>
                            </li>
                            <li><span class="title col-3">约课卡 </span><span class="content"><%=cont[i].reservation_mcard %></span></li>
                            <%
                            if(cont[i].cancel_reason){
                            %>
                            <li><span class="title col-3">取消原因 </span><span class="content"><%=cont[i].cancel_reason %></span></li>
                            <%
                            }
                            %>
                        </ul>
                    </div>
                <% } %>
        <% } %>
    </script> 
  <!-- /已约课程模板 --> 
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
    require(['fastclick', 'learnRecord'], function(FastClick, learnRecord) {
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