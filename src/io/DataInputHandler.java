package io;

import java.io.IOException;
import java.util.Scanner;

public interface DataInputHandler {
        void handleInput(Scanner scanner);
        void handleManualInputArray(Scanner scanner);
        void dataTextInputArray(Scanner scanner) throws IOException;
}
