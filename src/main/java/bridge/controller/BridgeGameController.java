package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private List<String> bridge;

    public void startBridgeGame() {
        init();
        do {
            bridgeGame.move(InputView.getMoving());
            OutputView.printMap(bridgeGame);
            if(bridgeGame.getGameSuccess()!="성공") {
                String gameCommand = InputView.getGameCommand();
                continueBrideGameCommand(gameCommand);
            }
        } while (bridgeGame.gameContinue());
        OutputView.printResult(bridgeGame);
    }

    public void continueBrideGameCommand(String gameCommand){
        if(gameCommand.equals("R")){
            bridgeGame.retry();
            bridgeGame.totalGamePlus();
        }
    }

    public void init() {
        OutputView.printGameStart();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(InputView.getBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }
}
