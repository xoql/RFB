	$(document).ready(function() {
		
		$(".submenu").hide();
		
		$(".menu li").hover(function() {
			$(".submenu").stop().slideDown(400);
		},function(){
			$(".submenu").stop().slideUp(600);
		});
		
		$(".submenu").hover(function() {
			$(".submenu").stop().slideDown(400);
		},function(){
			$(".submenu").stop().slideUp(600);
		});
		
		var menu1 = $(".menu li:nth-child(1)");
		var menu11 = $(".submenu li:nth-child(1) a");
		var menu2 = $(".menu li:nth-child(2)");
		var menu22 = $(".submenu li:nth-child(2) a");
		var menu3 = $(".menu li:nth-child(3)");
		var menu33 = $(".submenu li:nth-child(3) a");
		var menu4 = $(".menu li:nth-child(4)");
		var menu44 = $(".submenu li:nth-child(4) a");
		var menu5 = $(".menu li:nth-child(5)");
		var menu55 = $(".submenu li:nth-child(5) a");
		menu1.hover(function() {
			menu1.text("브랜드");
		},function(){
			menu1.text("Brand");
		});
		
		menu11.hover(function() {
			menu1.text("브랜드");
		},function(){
			menu1.text("Brand");
		});
		
		menu2.hover(function() {
			menu2.text("메뉴");
		},function(){
			menu2.text("Menu");
		});
		
		menu22.hover(function() {
			menu2.text("메뉴");
		},function(){
			menu2.text("Menu");
		});
		
		
		menu3.hover(function() {
			menu3.text("매장");
		},function(){
			menu3.text("Sotre");
		});
		
		menu33.hover(function() {
			menu3.text("매장");
		},function(){
			menu3.text("Sotre");
		});
		
		
		menu4.hover(function() {
			menu4.text("제휴");
		},function(){
			menu4.text("Benefit");
		});
		
		menu44.hover(function() {
			menu4.text("제휴");
		},function(){
			menu4.text("Benefit");
		});
		
		
		menu5.hover(function() {
			menu5.text("이벤트&뉴스");
		},function(){
			menu5.text("Event&News");
		});
		
		menu55.hover(function() {
			menu5.text("이벤트&뉴스");
		},function(){
			menu5.text("Event&News");
		});
	});