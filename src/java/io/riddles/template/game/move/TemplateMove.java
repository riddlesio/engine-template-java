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
import io.riddles.javainterface.game.move.AbstractMove;

/**
 * io.riddles.template.game.move.TemplateMove - Created on 25-10-17
 *
 * This class is used to store the move a bot has made. This is stored in a playerState.
 * If the move is wrong somehow, this is stored in the move as well.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplateMove extends AbstractMove {

    public TemplateMove() {

    }

    public TemplateMove(InvalidInputException exception) {
        super(exception);
    }
}
