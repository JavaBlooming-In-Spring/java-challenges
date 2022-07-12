## Java Challenges

- 학습한 자바를 사용하여 프로젝트를 직접 구현
- 리뷰를 통해 코드의 개선을 진행

### 방법

> https://github.com/JunHoPark93/woowacourse-projects

- 구현할 프로젝트는 다음을 참고하여 순서대로 진행합니다.
- `main` 브랜치를 사용하기보다는 프로젝트별 브랜치를 생성하여 진행합니다.
    - 예를 들어 숫자 야구 게임(java-baseball-precourse)을 진행하는 경우 브랜치명을 `java_baseball_precourse_홍길동`으로 생성합니다.
    - 구현이 완료되면 `PR`을 날리게 되고 `Review`가 진행됩니다.
    - Review가 완료되고 수정사항이 반영된 후 `main` 브랜치에 `MERGE` 합니다.
- 프로젝트 생성 시 폴더명은 아래의 규칙을 따릅니다.
    - 예를 들어 숫자 야구 게임(java-baseball-precourse)을 진행하는 경우 디렉토리를 `java-baseball-precourse`로 생성하고 해당 디렉토리 안 자신의 이름 영어 `HongGilDong` 디렉토리 안에서 작업을 진행합니다.
    - **java-baseball-precourse/HongGilDong**
- 커밋 메세지 구조
    - `Review`가 용이하도록 역할에 따라 `commit`을 적절히 분리합니다.
    - `feat` : 새로운 기능에 대한 커밋
    - `fix` : 버그 수정에 대한 커밋
    - `build` : 빌드 관련 파일 수정에 대한 커밋
    - `chore` : 그 외 자잘한 수정에 대한 커밋
    - `ci` : CI관련 설정 수정에 대한 커밋
    - `docs` : 문서 수정에 대한 커밋
    - `style` : 코드 스타일 혹은 포맷 등에 관한 커밋
    - `refactor` :  코드 리팩토링에 대한 커밋
    - `test` : 테스트 코드 수정에 대한 커밋