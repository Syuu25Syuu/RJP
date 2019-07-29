
$(function(){
   var x = 0, divx = 1, velx = 4;
   var moveImgTimerId;

   function moveImg(){
     $('.mawaru').css({left: x + 'px'});
     x = x + velx * divx;

     if((x + $('.mawaru').width() > 1840) || (x < 0)){
       divx = - divx;
       x = x + velx * divx;
     }
     moveImgTimerId = setTimeout(moveImg, 10);
   }
   // くれっしーくるくる
   moveImg();

   $('img').imgLiquid();

   // 画像の上にカーソルがあたっているときに、カーソルを指の形にする
   $('img').hover(function(){
      $(this).css("cursor","pointer");
   });

   // 画像をクリックしたらゲームへ飛ぶ処理
   $('img').click(function(){
      //画像のidを取得する
      var location = $(this).attr("id");

      if(location == "omikuji"){
         window.location.href = "omikuji/omikuji.html"
      }else if(location == "difference"){
         window.location.href = "difference/difference.html"
      }else if(location == "touchnumber"){
         window.location.href = "touchnumber/touchnumber.html"
      }

   });
})
