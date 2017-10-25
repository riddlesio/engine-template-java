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

package io.riddles.template.game;

import org.json.JSONArray;
import org.json.JSONObject;

import io.riddles.javainterface.game.AbstractGameSerializer;
import io.riddles.template.game.processor.TemplateProcessor;
import io.riddles.template.game.state.TemplateState;
import io.riddles.template.game.state.TemplateStateSerializer;

/**
 * io.riddles.template.game.TemplateSerializer - Created on 25-10-17
 *
 * Used to create a string representation of the game.
 *
 * @author Jim van Eeden - jim@riddles.io
 */
public class TemplateSerializer extends AbstractGameSerializer<TemplateProcessor, TemplateState> {

    /**
     * Adds the default stuff the game file needs and serializes the state. Depending on the
     * engine, some stuff might need to be added here.
     * @param processor The game processor
     * @param initialState The initial game state
     * @return The complete string representation of the game for the frontend matchviewer
     */
    @Override
    public String traverseToString(TemplateProcessor processor, TemplateState initialState) {
        TemplateStateSerializer stateSerializer = new TemplateStateSerializer();
        JSONObject game = new JSONObject();

        // Adds the default stuff that every game file needs
        game = addDefaultJSON(initialState, game, processor);

        JSONArray states = new JSONArray();
        states.put(stateSerializer.traverseToJson(initialState));

        TemplateState state = initialState;
        while (state.hasNextState()) {
            state = (TemplateState) state.getNextState();
            states.put(stateSerializer.traverseToJson(state));
        }

        game.put("states", states);

        return game.toString();
    }
}
