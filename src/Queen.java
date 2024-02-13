public class Queen extends Piece {

    public Queen(Color color, String ID, int startX, int startY) {
        super(color, ID, startX, startY);
    }

    @Override
    public boolean possibleMove(int x, int y) {
        Piece piece = Board.getPiece(x, y);

        if (this.sameColor(piece)) {
            return false;
        }

        if (!Board.isPathClear(getX(), getY(), x, y)) {
            return false;
        }

        int dx = Math.abs(getX() - x);
        int dy = Math.abs(getY() - y);

        if (dx == dy || dx == 0 || dy == 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.WHITE ? "♕" : "♛";
    }

    @Override
    public boolean canMove() {
        int x = this.getX();
        int y = this.getY();

        // Bishop-like movements
        while (--x >= 0 && --y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        while (++x <= 7 && --y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        while (--x >= 0 && ++y <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        while (++x <= 7 && ++y <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        // Rook-like movements
        while (--x >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        while (++x <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        while (++y <= 7) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        x = this.getX();
        y = this.getY();

        while (--y >= 0) {
            if (this.testMove(x, y)) {
                return true;
            }
        }

        return false;
    }
}
