public class Knight extends Piece {

	public Knight(Color color, String id, int startX, int startY) {
		super(color, id, startX, startY);
	}

	@Override
	public boolean possibleMove(int x, int y) {
		if (this.sameColor(Board.getPiece(x, y))) {
			return false;
		}

		int xDistance = Math.abs(this.getX() - x);
		int yDistance = Math.abs(this.getY() - y);
		return (xDistance == 1 && yDistance == 2) || (xDistance == 2 && yDistance == 1);
	}

	@Override
	public String toString() {
		return (this.getColor() == Color.WHITE) ? "♘" : "♞";
	}

	@Override
	public boolean canMove() {
		int x = this.getX();
		int y = this.getY();

		int[][] moves = { { -2, -1 }, { -1, -2 }, { 2, -1 }, { 1, -2 }, { -2, 1 }, { -1, 2 }, { 2, 1 }, { 1, 2 } };

		for (int[] move : moves) {
			if (this.testMove(x + move[0], y + move[1])) {
				return true;
			}
		}

		return false;
	}
}
