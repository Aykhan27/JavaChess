public class Bishop extends Piece {

    public Bishop(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    @Override
    public boolean possibleMove(int x, int y) {
        if (this.sameColor(Board.getPiece(x, y))) {
            return false;
        }

        if (Math.abs(getX() - x) != Math.abs(getY() - y)) {
            return false;
        }

        return Board.isPathClear(getX(), getY(), x, y);
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "♗" : "♝";
    }

    @Override
    public boolean canMove() {
        int originX = this.getX();
        int originY = this.getY();

        // Reset x and y to the original position after each while loop
        int x = originX;
        int y = originY;

        // Top left
        while (--x >= 0 && --y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = originX;
        y = originY;

        // Top right
        while (++x <= 7 && --y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = originX;
        y = originY;

        // Bottom left
        while (--x >= 0 && ++y <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = originX;
        y = originY;

        // Bottom right
        while (++x <= 7 && ++y <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        return false;
    }
}
