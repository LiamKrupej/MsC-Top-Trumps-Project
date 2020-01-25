import java.io.FileNotFoundException;

public class TTController {

	private TTModel model;
	private TTView	view;

	public TTController(TTModel tModel, TTView tView) {
		model = tModel;
		view = tView;
	}

	public void startGame() throws FileNotFoundException{
		model.readCards();
		model.shuffleDeck();
	}
	
}