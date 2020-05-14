$(document).ready(function () {
    $("li").hover(function () {
            $(this).css("color", "cyan");
        },
        function () {
            $(this).css("color", "white");
        });

    // 뷰포트 무한 반복
    setInterval(function () {
        var div = $(".Viewmore");
        div.animate({
            top: '35%'
        }, "slow");
        div.animate({
            top: '36%'
        }, "slow");
    }, 1000); // 매 1초마다 반복 실행



});

// $('article').each(function(index){
//     $(this).attr("data-index",win_h*index);
// });

// $('article').on("mousewheel",function(e){
//     var articlePos = parseInt($(this).attr("data-index"));
//     if(e.originalEvent.wheelDelta >= 0){
//         $("html,body").stop().animate({scrollTop:sectionPos - win_h});

//         return false;
//     } else if (e.originalEvent.wheelDelta < 0){

//         $("html,body").stop().animate({scrollTop:sectionPos - win_h});

//         return false;
//     }

// })