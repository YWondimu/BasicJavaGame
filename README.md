# BasicJavaGame

## Introduction

This is a very basic, terminal-based game written in java. The purpose of making this game is:

1) To develop my programming ability.
2) To learn more about how collaborative programming works through practice. (But currently, I am the only one working on this game.)
3) To make something cool!

The game is run in the terminal, but in the future might use a GUI... It's a work in progress, so I'll add more in here as features develop haha.

## Screenshots

Below are some screenshots to give an idea of how the game looks, for now:

![screenshot of game start screen](/PicturesForReadme/Screen%20Shot%202022-01-23%20at%208.32.09%20PM.png "Screenshot of Game")

![screenshot of game in action](/PicturesForReadme/Screen%20Shot%202022-01-23%20at%208.33.14%20PM.png "Screenshot of Game")

## Installation

To run and play the game you will need to have java installed on your computer.
You can then make a folder somewhere (e.g. called "BasicJavaGame") and clone this git repository into it.

`git clone https://github.com/YWondimu/BasicJavaGame/`

## Running the Game

The following command starts the game.

`javac *.java && java RunCombat`

## Quitting the Game

To quit the game after having started, type "q", then press enter.

## Game Rules and Gameplay

Both Player 1 and the Enemy NPC have 5 lives, and 5 units of mana.
The aim of the game is to bring the NPC's lives down to 0, without losing all 5 of your own lives yourself.

Each turn you can do 1 of 3 things:
- attack
- recharge mana
- defend

The Enemy NPC will also do one of those 3 things, at the same time that you do.

### Attacking

To attack, type "a", then press enter. 
If the Enemy NPC is not defending, they lose 1 life.
Each attack uses up 1 unit of your mana.

### Recharching Mana

To recharge mana, type "s", then press enter.
Each attack uses 1 unit of mana. If you do not have any mana, you cannot attack.

### Defending

To defend, type "d", then press enter.
If the Enemy NPC is attacking, you will not lose any lives.

## Future Features To Add

If I further develop this game, the below are features that I might add. I think, at this point, the only feature I am likely to work on is animation. The rest are unlikely to be added (except maybe bazooka, reflect, and more intelligent NPC behaviour).

I might not add features in the exact order below; but the higher up the list a feature is, the more likely I am to add it.

- animation
- bazooka option (breaks through defense, but uses 3 units of mana)
- reflect option (reflects an attack, but uses 1 unit of mana)
- more intelligent behaviour for Enemy NPC
- different types of NPC's (aggressive, defensive, mystery, random, smart)
- add levels of difficulty that are either always available or unlocked as user progresses through the game
- save history
- two player mode
- GUI
