public class Rook extends Piece {
    public boolean isFirstMove = true;

    public Rook(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    @Override
    public boolean possibleMove(int x, int y) {
        Piece piece = Board.getPiece(x, y);

        if (this.sameColor(piece)) {
            return false;
        }

        if (getX() != x && getY() != y) {
            return false;
        }

        return Board.isPathClear(getX(), getY(), x, y);
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "♖" : "♜";
    }

    @Override
    public boolean canMove() {
        int x = this.getX();
        int y = this.getY();

        // Move left
        while (--x >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        // Move right
        while (++x <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        // Move down
        while (++y <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        // Move up
        while (--y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        return false;
    }
}