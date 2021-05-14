$(function(){
    mainInit()
})
function mainInit(){
    Mvisual();
}

function Mvisual(){
    var $mainli = $('#main-visual .visual li a')
    var $pagingli = $('#visual .paging li')
    var $next = $('.btn-wrap .next'); 
            var $prev = $('.btn-wrap .prev');
            var current = 0 ;
            var old = 0;
    var current = 0, old = 0 , size = $mainli.length , timer=0, interval=5000;

    $next.click(function(){
        //증가
        current ++;
        //조건 
        if( current > 4 ) {
            current = 0 
        }
        //결과
        $mainli.eq(current).css({left:'100%'}).animate({left:0},400);
        $mainli.eq(old).css({left:0}).animate({left:'-100%'},400);
        $pagingli.removeClass('on');
        $pagingli.eq(current).addClass('on');
        old = current 
    })
    $prev.click(function(){
        //증가
        current--;
        //조건 
        if( current < 0 ) {
            current = 4 
        }
        //결과
        $mainli.eq(current).css({left:'-100%'}).animate({left:0},400);
        $mainli.eq(old).css({left:0}).animate({left:'100%'},400);
        $pagingli.removeClass('on');
        $pagingli.eq(current).addClass('on');
        old = current 
    })





    timer = setInterval ( make , interval );
    function make() {
        current++;
        if( current > size - 1) {
            current = 0
        }
        banner();
    }

    $pagingli.click(function(){
        current = $(this).index();
        if( current !=old ){
            banner();
        }
        
    })

    

function banner(){
    $mainli.eq(current).stop().css({left:'100%'})
    .animate({left:0},400);

    $mainli.eq(old).stop().css({left:0})
           .animate({left:'-100%'},400);

    $pagingli.removeClass('on');
    $pagingli.eq(current).addClass('on');
    old = current ;

    clearInterval( timer );
    timer = setInterval( make , interval );
}

}

$(document).ready(function(){
    //최상단 체크박스 클릭
    $("#checkall").click(function(){
         
        if($("#checkall").prop("checked")){ //클릭되었으면
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=agree1]").prop("checked",true);
            $("input[name=agree2]").prop("checked",true);
            
        }else{ //클릭이 안되있으면
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=agree1]").prop("checked",false);
            $("input[name=agree2]").prop("checked",false);
        }
    })
})



