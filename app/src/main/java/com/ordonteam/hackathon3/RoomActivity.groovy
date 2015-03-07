package com.ordonteam.hackathon3

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.games.Games
import com.google.android.gms.games.GamesStatusCodes
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
import com.google.android.gms.games.multiplayer.realtime.Room
import com.google.android.gms.games.multiplayer.realtime.RoomConfig
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
import groovy.transform.CompileStatic

import static com.google.android.gms.games.GamesActivityResultCodes.RESULT_LEFT_ROOM

@CompileStatic
abstract class RoomActivity extends LoginActivity implements RoomUpdateListener, RealTimeMessageReceivedListener {

    public static final int RC_WAITING_ROOM = 9007

    @Override
    void onConnected(Bundle bundle) {
        Bundle am = RoomConfig.createAutoMatchCriteria(1, 1, 0);

        RoomConfig roomConfig = RoomConfig.builder(this).setMessageReceivedListener(this).setAutoMatchCriteria(am).build();

        Games.RealTimeMultiplayer.create(client, roomConfig);
    }

    @Override
    void onRoomCreated(int statusCode, Room room) {
        onCreationCallback(statusCode, room)
    }

    @Override
    void onJoinedRoom(int statusCode, Room room) {
        onCreationCallback(statusCode, room)
    }

    private void onCreationCallback(int statusCode, Room room) {
        if (statusCode != GamesStatusCodes.STATUS_OK) {
            onRoomCreationFailure(statusCode)
        } else {
            Intent i = Games.RealTimeMultiplayer.getWaitingRoomIntent(client, room, Integer.MAX_VALUE);
            startActivityForResult(i, RC_WAITING_ROOM);
        }
    }

    @Override
    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {

    }

    abstract void onRoomCreationFailure(int statusCode)

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        if (requestCode == RC_WAITING_ROOM) {
            if (responseCode == RESULT_OK) {
                startGame()
            } else if (responseCode in [RESULT_CANCELED, RESULT_LEFT_ROOM]) {
                //Games.RealTimeMultiplayer.leave(client, null, mRoomId);
            }
        } else {
            super.onActivityResult(requestCode, responseCode, data)
        }
    }

    abstract void startGame()

    @Override
    void onLeftRoom(int i, String s) {

    }

    @Override
    void onRoomConnected(int statusCode, Room room) {

    }
}
