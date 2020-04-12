
* 해당 소스는 아래 google drive 공유링크를 통해서도 확인 가능합니다.
https://drive.google.com/open?id=1zM2UBsdm4HDFbWGCuGyBJEd0wuJ70mTk

## 어플리케이션 스펙
  1. jdk 1.8
  2. spring boot framework 2.2.7 (snapshot)
  3. jpa (2.2.6)
  4. h2 (1.4.2)
  5. tomcat (8.5.30)
  
## 문제 해결 방법
  1. HTTP Method 기반의 어플리케이션을 위한 간단한 rest api 개발
  2. 기초데이터를 insert하기 위해 h2 (In memory DB) dependency 추가
     <pre><code>@Query(value="SELECT B2.BR_NAME AS BR_NAME, B2.BR_CODE AS BR_CODE, ...", nativeQuery=true)
     List<SumAmtByBranch> getSumAmtByBranch(@Param("brName")String brName);
     </code></pre>
  3. json object가 아닌 json array 데이터형이 필요한 경우, array index와 key(year)를 이용한 service에서 로직처리
    <pre><code>
    for (int currIndex = 0; currIndex < sumAmtByYearBranchArrList.size(); currIndex++) {
    
			if(!sumAmtByYearBranchArrList.get(currIndex).getYear().equals(year) && fromToFlag) { //fromIndex
				if(currIndex == 0)	fromIndex = currIndex;
				else	fromIndex = currIndex-1;

				fromToFlag = false;
				
				year = sumAmtByYearBranchArrList.get(fromIndex).getYear();
				continue;
			}
			
      ...
    </code></pre>
  4. 지점 통폐합 케이스에 따른 exception custom을 위해 RuntimeException을 상속받는 NotFoundException 클래스 추가
      - 동일경로의 ApiExceptionHandler에서 @ExceptionHandler(NotFoundException.class) 를 통한 exception handel.
 
## 빌드 및 실행방법
  1. STS 다운로드 -> https://spring.io/tools
  2. jdk 1.8 다운로드 -> https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html
  3. 깃허브 프로젝트 소스 import -> (참조)https://huskdoll.tistory.com/471
  4. build path 설정
     1) ![bulid_1](https://user-images.githubusercontent.com/20430031/79064322-e08cd300-7ce2-11ea-93dc-4a64e6ad258a.png)
     2) ![bulid_2](https://user-images.githubusercontent.com/20430031/79064323-e1256980-7ce2-11ea-97ab-9b4a1d55e977.png)
     3) ![bulid_3](https://user-images.githubusercontent.com/20430031/79064324-e1256980-7ce2-11ea-9453-b51a28ba4c57.png)
     4) ![bulid_4](https://user-images.githubusercontent.com/20430031/79064325-e1be0000-7ce2-11ea-9001-eb8fdfefa3a4.png)
  5. 각각 순서대로 maven clean / maven install / spring boot app 실행
    ![application_start](https://user-images.githubusercontent.com/20430031/79064319-df5ba600-7ce2-11ea-8745-fa1f7683bc63.png)
  6. 브라우저에서 http://localhost:9999/ 로 접속하여 각 기능 test 가능
     (postman tool을 이용하여 test 가능)

  




