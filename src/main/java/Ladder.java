/*
* TO-DO
* - 음수값 예외 처리(declare, drawLine) -> 객체
* - ladderHeight 보다 큰 position 불가
* - numberOfLadders 보다 큰 ladder 불가
* lineMap을 별도의 객체로 두고 수정되었을 떄도 수정된 lineMap 객체를 반환하도록
* - 해당 position 및 짝대기에 에 이미 선이 그어진 경우 -> 못하게, 다른 짝대기에는 가능
* */

/*
* 객체지향 9원칙
* 1. 한 메서드에 한 단계의 들여쓰기
* 2. else 예약어 사용x -> 조기 return
* 3. 모든 원시값과 문자열 포장
* 4. 힌즐에 점 하나만
* 5. 변수, 메서드 이름 예쁘게
* 6. 모든 엔티티 작게 유지
* 7. 3개 이상의 인스턴트 변수를 가진 클래스x
* 8. 일급 컬렉샨
* 9. Getter, Setter 최소 사용
* */

public class Ladder {
    private int numberOfLadders;
    private int ladderHeight;
    private Lines lineMap;

    public Ladder(NaturalNumber numberOfLadders, NaturalNumber ladderHeight) {
        this.numberOfLadders = numberOfLadders.getNumber();
        this.ladderHeight = ladderHeight.getNumber();
        lineMap = new Lines(this.ladderHeight+1,this.numberOfLadders+1);
    }

    public int getNumberOfLadders() {
        return numberOfLadders;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int returnLineMapValue(int position, int selectedLadder) {
        return lineMap.getCellValue(position, selectedLadder);
    }

    /*  position에 들어가야 하는 것
    *   1. 선택된 두 개의 사다리(A, B)
    *   2. 사다리 A의 연결 위치, 사다리 B의 연결 위치
    *   3. Position 객체 생성
    * */
    public void drawLine(NaturalNumber ladderA, NaturalNumber ladderB, NaturalNumber position){
        if (ladderA.getNumber() > numberOfLadders || ladderB.getNumber() > numberOfLadders || position.getNumber() > ladderHeight) {
            throw new IllegalArgumentException();
        }
        lineMap.addLine(ladderA.getNumber(), ladderB.getNumber(), position.getNumber());
    }

    public int run(NaturalNumber selectedLadder){
        if(selectedLadder.getNumber()>numberOfLadders) {
            throw new IllegalArgumentException();
        }
        int currentHeight=1;
        while(currentHeight<=this.ladderHeight){
            if(!lineMap.isCellEmpty(currentHeight, selectedLadder.getNumber())){
                selectedLadder = NaturalNumber.from(lineMap.getCellValue(currentHeight,selectedLadder.getNumber()));
            }
            currentHeight++;
        }
        return selectedLadder.getNumber();
    }

//    public int run(int selectedLadder){
//        if(selectedLadder<1) {
//            throw new IllegalArgumentException();
//        }
//        if(selectedLadder>numberOfLadders) {
//            throw new IllegalArgumentException();
//        }
//        int currentHeight=1;
//        while(currentHeight<=this.ladderHeight){
//            if(lineMap[currentHeight][selectedLadder]!=0){
//                selectedLadder = lineMap[currentHeight][selectedLadder];
//            }
//            currentHeight++;
//        }
//        return selectedLadder;
//    }
}
