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

package io.riddles.template.game.state;

import io.riddles.javainterface.game.state.AbstractPlayerState;
import io.riddles.template.game.move.TemplateMove;

/**
 * io.riddles.template.game.state.TemplatePlayerState - Created on 25-10-17
 *
 * This class is used to store anything needed about a player. Each playerState should
 * be cloned each time the state is cloned to create the next state.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplatePlayerState extends AbstractPlayerState<TemplateMove> {

    /**
     * This constructor is only used to create a new playerState (the initial state
     * in the game engine).
     * @param playerId Player ID.
     */
    public TemplatePlayerState(int playerId) {
        super(playerId);
    }

    /**
     * Use this constructor to clone the given playerstate.
     * @param playerState PlayerState that needs to be cloned.
     */
    public TemplatePlayerState(TemplatePlayerState playerState) {
        super(playerState.playerId);
    }
}
