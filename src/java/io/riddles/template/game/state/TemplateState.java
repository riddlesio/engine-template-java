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

import java.util.ArrayList;

import io.riddles.javainterface.game.state.AbstractState;

/**
 * io.riddles.template.game.state.TemplateState - Created on 25-10-17
 *
 * This class is used to store everything about the game. In the engine the first state
 * is created, then in the processor each next state is created by cloning the old state and
 * then updating the newly created state. At game end, the states are used to get the
 * string representation of the game as well.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplateState extends AbstractState<TemplatePlayerState> {

    /**
     * Use this to create the initial state.
     * @param playerStates The player states.
     */
    public TemplateState(ArrayList<TemplatePlayerState> playerStates) {
        super(null, playerStates, 0);
    }

    /**
     * Use this to create any next state, giving the state before it.
     * @param previousState The previous (current) state.
     * @param playerStates The player states.
     * @param roundNumber The round number for the new state.
     */
    public TemplateState(TemplateState previousState, ArrayList<TemplatePlayerState> playerStates, int roundNumber) {
        super(previousState, playerStates, roundNumber);
    }

    /**
     * Recommended way to create the next state from the current state, which
     * will create a copy of the current state. This next state will initially be the same as
     * the current state, but can be updated by the processor.
     * @param roundNumber The round number for the new state.
     * @return A clone of this state.
     */
    public TemplateState createNextState(int roundNumber) {
        // Create new player states from current player states
        ArrayList<TemplatePlayerState> playerStates = new ArrayList<>();
        for (TemplatePlayerState playerState : this.getPlayerStates()) {
            playerStates.add(new TemplatePlayerState(playerState));
        }

        // Create new state from current state
        return new TemplateState(this, playerStates, roundNumber);
    }
}
