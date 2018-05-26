package com.techlabs.tic.tac.toe.game;

public class Board {

	private Cell[] cells;

	public Board() {
		this.cells = new Cell[9];
		for (int i = 0; i < cells.length; i++) {
			this.cells[i] = new Cell();
		}

	}

	public Cell[] getCells() {
		return cells;
	}

	public boolean setCell(int position, Mark mark) {
		return this.cells[position - 1].setMark(mark);
	}

	public boolean isEmpty() {
		for (Cell cell : this.cells) {
			if (cell.getMark() != null)
				return false;
		}

		return true;
	}
	
	public boolean isFull() {
		for (Cell cell : this.cells) {
			if (cell.getMark() == null)
				return false;
		}

		return true;
	}

}
