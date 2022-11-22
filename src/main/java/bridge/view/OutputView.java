package bridge.view;

import bridge.model.BridgeGame;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.view.ViewEnum.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static void printGameStart() {
        System.out.println(OUTPUT_GAME_START_MESSAGE.getMessage());
    }

    public static void printMap(BridgeGame bridgeGame) {
        int bridgeSize = bridgeGame.getUpPresentBridge().size();

        System.out.print("[");
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals("U")) {
                System.out.printf(" %s |", bridgeGame.getUpPresentBridge().get(i));
            } else {
                System.out.print("   |");
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals("U")) {
            System.out.printf(" %s ]\n", bridgeGame.getUpPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf("   ]\n");
        }

        System.out.print("[");
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals("D")) {
                System.out.printf(" %s |", bridgeGame.getDownPresentBridge().get(i));
            } else {
                System.out.print("   |");
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals("D")) {
            System.out.printf(" %s ]\n", bridgeGame.getDownPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf("   ]\n");
        }

        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals("D")) {
            if (bridgeGame.getDownPresentBridge().get(bridgeSize - 1).equals("X")) {
                throw new IllegalArgumentException();
            }
        } else
            if (bridgeGame.getUpPresentBridge().get(bridgeSize - 1).equals("X")) {
                throw new IllegalArgumentException();
            }
        }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(OUTPUT_GAME_RESULT_MAP_PRINT_MESSAGE.getMessage());

        int bridgeSize = bridgeGame.getUpPresentBridge().size();

        System.out.print("[");
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals("U")) {
                System.out.printf(" %s |", bridgeGame.getUpPresentBridge().get(i));
            } else {
                System.out.print("   |");
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals("U")) {
            System.out.printf(" %s ]\n", bridgeGame.getUpPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf("   ]\n");
        }

        System.out.print("[");
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals("D")) {
                System.out.printf(" %s |", bridgeGame.getDownPresentBridge().get(i));
            } else {
                System.out.print("   |");
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals("D")) {
            System.out.printf(" %s ]\n", bridgeGame.getDownPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf("   ]\n");
        }
        System.out.printf(OUTPUT_GAME_RESULT_MESSAGE.getMessage(),bridgeGame.getGameSuccess());
        System.out.printf(OUTPUT_TOTAL_GAME_COUNT_MESSAGE.getMessage(),bridgeGame.getGameCount());
    }
}
