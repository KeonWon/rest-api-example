<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과제전형 - 이건원</title>
<script src="../js/jquery-3.4.1.js"></script>
<script>
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();

		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

	var TAB = ' ';
	function prettyJson(jsonText) {
		if (!jsonText) {
			return jsonText;
		}
		
		var prettyJson = new Array();
		var depth = 0;
		var currChar;
		var prevChar;
		var doubleQuoteIn = false;
		for (var i = 0; i < jsonText.length; i++) {
			currChar = jsonText.charAt(i);
			if (currChar == '\"') {
				if (prevChar != '\\') {
					doubleQuoteIn = !doubleQuoteIn;
				}
			}
			switch (currChar) {
			case '{':
				prettyJson.push(currChar);
				if (!doubleQuoteIn) {
					prettyJson.push('</br>');
					insertTab(prettyJson, ++depth);
				}
				break;
			case '}':
				if (!doubleQuoteIn) {
					prettyJson.push('</br>');
					insertTab(prettyJson, --depth);
				}
				prettyJson.push(currChar);
				break;
			case ',':
				prettyJson.push(currChar);
				if (!doubleQuoteIn) {
					prettyJson.push('</br>');
					insertTab(prettyJson, depth);
				}
				break;
			default:
				prettyJson.push(currChar);
				break;
			}
			prevChar = currChar;
		}
		return prettyJson.join('');
	}
	function insertTab(prettyJson, depth) {
		for (var i = 0; i < depth; i++) {
			prettyJson.push(TAB);
		}
	}

	function getMethodCall(questDv) {

		var url = "";
		if (questDv == "1") {
			url = "search/history/most-amt-by-year";
		} else if (questDv == "2") {
			url = "search/history/no-trans-except-this-year";
		} else if (questDv == "3") {
			url = "search/history/sum-amt-by-year-branch";
		} else if (questDv == "4") {
		}

		$.ajax({
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			type : 'get',
			url : url,
			success : function(response, status, request) {
				var jsonData = JSON.stringify(response);
				$('#getMethodTarget' + questDv).html(prettyJson(jsonData));
			},
			error : function(response, status, error) {
				var html = "status : " + response.status + "</br>"
							+ JSON.stringify(response.responseJSON);
				$('#getMethodTarget' + questDv).html(prettyJson(html));
			}
		})
	}

	function postMethodCall() {
		var data = JSON.stringify($("#testForm").serializeObject());
		$.ajax({
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			type : 'post',
			url : 'search/history/sum-amt',
			data : data,
			success : function(response, status, request) {
				var jsonData = JSON.stringify(response);
				$('#postMethodTarget').html(prettyJson(jsonData));
			},
			error : function(response, status, error) {
				var html = "status : " + response.status + "</br>"
							+ JSON.stringify(response.responseJSON);
				$('#postMethodTarget').html(prettyJson(html));
			}
		})
	}
</script>
</head>
<body>

	1. 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
	<form>
		<input type="button" value="확인" onclick="getMethodCall('1');">
	</form>
	<div id="getMethodTarget1"></div>
	</br>
	</br>
	</br> 
	
	2. 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발. (취소여부가 ‘Y’ 거래는 취소된 거래임)
	<form>
		<input type="button" value="확인" onclick="getMethodCall('2');">
	</form>
	<div id="getMethodTarget2"></div>
	</br>
	</br>
	</br> 
	
	3. 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임)
	<form>
		<input type="button" value="확인" onclick="getMethodCall('3');">
	</form>
	<div id="getMethodTarget3"></div>
	</br>
	</br>
	</br>

	4. 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
	<form id="testForm" name="testForm">
		<input type="text" id="brName" name="brName"></br> <input
			type="button" value="확인" onclick="postMethodCall();">
	</form>
	<div id="postMethodTarget"></div>

</body>
</html>