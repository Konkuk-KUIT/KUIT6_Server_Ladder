public class LadderGame
{
    // 사다리 번호는 1번부터니까 입력 자체를 NaturalNumber로 받기
    public NaturalNumber runGame(Ladder ladder,  NaturalNumber numberOfLadder)
    {
        // 인덱스로 사용하기 위해서 0번부터 접근 가능하도록 변환
        int position = numberOfLadder.getNumber() - 1;

        // numberOfLadder가 이미 자연수니까 1 이상
        // -> position은 0 이상이니 따로 boolean에 조건 추가 x
        boolean canStartGame = position <= numberOfLadder.getNumber();

        Row[] rows = ladder.getRows();

        if (!canStartGame) throw new IllegalArgumentException("해당 사다리는 존재하지 않습니다.");

        // 위치 변경
        for (int i = 0; i < rows.length; i++) {
            switch(rows[i].getLadderStates()[position]) {
                case LEFT -> position--;
                case RIGHT -> position++;
            }
        }

        // position은 int type이므로 NaturalNumber로 바꿔서 도착한 사다리 번호 반환
        return NaturalNumber.from(position + 1);
    }
}
