package io.textInput;

import data.Korneplod;

public class FileKorneplodInput extends FileReaderDataInput<Korneplod> {
        @Override
        protected Korneplod parseLine(String[] parts) throws NumberFormatException {
            String type = parts[0].trim();
            double weight = Double.parseDouble(parts[1].trim());
            String color = parts[2].trim();
            return new Korneplod.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build();
        }
}
