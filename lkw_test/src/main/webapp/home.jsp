<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�������� - �̰ǿ�</title>
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

	1. 2018��, 2019�� �� ������ �հ� �ݾ��� ���� ���� ���� �����ϴ� API ����.(��, ��ҿ��ΰ� ��Y�� �ŷ��� ��ҵ� �ŷ���, �հ� �ݾ��� �ŷ��ݾ׿��� �����Ḧ ������ �ݾ���)
	<form>
		<input type="button" value="Ȯ��" onclick="getMethodCall('1');">
	</form>
	<div id="getMethodTarget1"></div>
	</br>
	</br>
	</br> 
	
	2. 2018�� �Ǵ� 2019�⿡ �ŷ��� ���� ���� �����ϴ� API ����. (��ҿ��ΰ� ��Y�� �ŷ��� ��ҵ� �ŷ���)
	<form>
		<input type="button" value="Ȯ��" onclick="getMethodCall('2');">
	</form>
	<div id="getMethodTarget2"></div>
	</br>
	</br>
	</br> 
	
	3. ������ �������� �ŷ��ݾ� �հ踦 ���ϰ� �հ�ݾ��� ū ������ ����ϴ� API ����.( ��ҿ��ΰ� ��Y�� �ŷ��� ��ҵ� �ŷ���)
	<form>
		<input type="button" value="Ȯ��" onclick="getMethodCall('3');">
	</form>
	<div id="getMethodTarget3"></div>
	</br>
	</br>
	</br>

	4. �д����� �Ǳ����� �������Ͽ� �Ǳ������� ������ �̰��� �Ͽ����ϴ�. �������� �Է��ϸ� �ش������� �ŷ��ݾ� �հ踦 ����ϴ� API ����( ��ҿ��ΰ� ��Y�� �ŷ��� ��ҵ� �ŷ���,)
	<form id="testForm" name="testForm">
		<input type="text" id="brName" name="brName"></br> <input
			type="button" value="Ȯ��" onclick="postMethodCall();">
	</form>
	<div id="postMethodTarget"></div>

</body>
</html>