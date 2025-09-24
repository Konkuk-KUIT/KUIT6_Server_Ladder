public class Height {
    private int height;

    public Height(int height) {
        if(height < 0) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_NATURE_NUMBER.getMessage());
        }
        this.height = height;
    }

    public int current() {
        return this.height;
    }
}