<!doctype html>
<html lang="en">
 <head> 
  <meta charset="UTF-8"> 
  <title>随心瑜掌馆</title> 
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"> 
  <meta name="format-detection" content="telephone=no, email=no"> 
  <link rel="stylesheet" href="./css/reset.css?v=1chn3qojv"> 
  <link rel="stylesheet" href="./css/style.css?v=1chn3qojv"> 
  <script src="./js/lib/flexible.min.js?v=static"></script>
 </head> 
 <body> 
  <div class="m-register-box"> 
   <div class="step-box" id="stepBox"> 
    <div class="step-item js-step"> 
     <div class="title">
      恭喜您成为第
      <span class="register-total" id="total"></span>位注册随心瑜掌馆的馆主！
     </div> 
     <div class="feild-box"> 
      <input type="text" class="inp-normal_full" id="J_Phone" placeholder="手机号（将作为登录账号）"> 
     </div> 
     <div class="feild-box hide clear"> 
      <input type="text" class="fl inp-442-86" id="J_ImgCode" placeholder="验证码" value="1234"> 
      <img src="" alt="图形验证码" class="fr code-img hide" id="J_GetImgCode"> 
     </div> 
     <div class="feild-box feild-sms clear"> 
      <input type="tel" class="fl" id="J_Code" placeholder="请输入短信验证码"> 
      <span class="fr btn-get-sms" id="J_GetCode">获取验证码</span> 
     </div> 
     <div class="feild-box"> 
      <input type="password" class="inp-normal_full" id="J_PWD" placeholder="密码，6-20位，支持字母，数字，符号_$。"> 
     </div> 
     <div class="btn-register"> 
      <button type="button" class="btn-normal_full btn-next js-next">下一步</button> 
     </div> 
     <div class="agreement-tips">
       注册即同意
      <a href="agreement.php" target="_blank">《随心瑜掌馆服务协议》</a> 
     </div> 
    </div> 
    <div class="step-item js-step hide"> 
     <div class="feild-box"> 
      <input type="text" class="inp-normal_full" id="J_Brand" placeholder="品牌名称（必填）"> 
     </div> 
     <div class="feild-box"> 
      <input type="text" class="inp-normal_full" id="J_Site" placeholder="场馆名称（必填）"> 
     </div> 
     <div class="feild-box"> 
      <input type="text" class="inp-normal_full" id="J_Boss" placeholder="申请人（必填）"> 
     </div> 
     <div class="feild-box clear"> 
      <select name="province" class="fl space-mr15 select-normal_3p" id="J_Province" onchange="changeComplexProvince(this.value, sub_array, 'J_City', 'J_Area');"></select> 
      <select name="city" class="fl select-normal_3p" id="J_City" onchange="changeCity(this.value,'J_Area','J_Area');"></select> 
      <select name="area" class="fr select-normal_3p" id="J_Area"></select> 
     </div> 
     <div class="feild-box"> 
      <div class="source-tips">
       您是通过何种渠道了解到随心瑜掌馆？
      </div> 
      <select name="source" class="select-normal_full" id="J_Source"> <option value="">请选择</option> </select> 
     </div> 
     <div class="btn-register"> 
      <button type="button" class="btn-normal_full btn-save js-next" id="save">提交</button> 
     </div> 
     <div class="agreement-tips">
       注册即同意
      <a href="agreement.php" target="_blank">《随心瑜掌馆服务协议》</a> 
     </div> 
    </div> 
    <div class="step-item js-step hide"> 
     <div class="welcome-tips"> 
      <p class="welcome-title">恭喜您获得随心瑜掌馆<strong>免费体验</strong>资格！</p> 
      <p class="welcome-thumb"><img src="img/member.png?v=1chn3qojv" alt=""></p> 
      <p class="welcome-tips-cont">已为您分配专属技术顾问，请添加下方微信<br>为您开通随心瑜掌馆！</p> 
     </div> 
     <div class="saler-info"> 
      <div class="saler-name" id="sname"></div> 
      <a href="tel:13811287561" class="saler-phone" id="sphone"></a> 
      <div class="saler-qrcode"> 
       <div class="saler-qrcode-content">
        <img src="" alt="" id="sqrcode">
       </div> 
       <div class="saler-qrcode-tips">
        识别二维码
        <br>联系技术顾问
       </div> 
      </div> 
     </div> 
    </div> 
   </div> 
  </div> 
  <div id="validInfoBox"></div> 
  <script src="js/lib/AreaData.js?v=static"></script> 
  <script src="js/lib/Area.js?v=static"></script> 
  <script src="./js/lib/jquery-2.2.4.min.js?v=static"></script> 
  <script src="./js/lib/require.min.js?v=static"></script> 
  <script src="./js/main.js?v=1chn3qojv"></script> 
  <script>
        require(['fastclick','register'],function(FastClick,register){
            //do something
            FastClick.attach(document.body);
            initComplexArea('J_Province', 'J_City', 'J_Area', area_array, sub_array, sub_arr, '0', '0', '0');
        });
    </script> 
  <!-- CNZZ统计 --> 
  <div class="hide"> 
   <script src="//s4.cnzz.com/z_stat.php?id=1262504917&amp;web_id=1262504917" language="JavaScript"></script> 
   <script>
        //自定义监控
        _czc.push(["_setAccount", "1262504917"]);
    </script> 
  </div> 
 </body>
</html>