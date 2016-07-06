
public class Test {

	public static void main (String[]args){
		GoL game = new GoL();
		game.grid.addCell(1, 1);
		game.grid.addCell(5, 5);
		game.grid.addCell(20, 20);
		game.grid.removeCell(5, 5);
	}
	
}
