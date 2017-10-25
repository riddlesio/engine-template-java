/*
 *  Copyright 2017 riddles.io (developers@riddles.io)
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *
 *      For the full copyright and license information, please view the LICENSE
 *      file that was distributed with this source code.
 */

package io.riddles.template.game.move;

import io.riddles.javainterface.exception.InvalidInputException;
import io.riddles.javainterface.serialize.Deserializer;

/**
 * io.riddles.template.game.move.TemplateMoveDeserializer - Created on 25-10-17
 *
 * This class is used to parse the input by the bots.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplateMoveDeserializer implements Deserializer<TemplateMove> {

    /**
     * Takes the bot's input and parses it. Invalid inputs by the bot are stored
     * in the move as well.
     * @param string Bot input.
     * @return The parsed input in a Move representation.
     */
    @Override
    public TemplateMove traverse(String string) {
        try {
            return visitMove(string);
        } catch (InvalidInputException ex) {
            return new TemplateMove(ex);
        } catch (Exception ex) {
            return new TemplateMove(new InvalidInputException("Failed to parse action"));
        }
    }

    /**
     * Parse the bot input. Throw an InvalidInputException with the error description if
     * the bot's input is wrong somehow.
     * @param input Bot input.
     * @return The parsed input in a Move representation.
     * @throws InvalidInputException Thrown if the bot's input is wrong.
     */
    private TemplateMove visitMove(String input) throws InvalidInputException {
        return null;
    }
}
