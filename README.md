# Camera from the Martian movie

**1st year course project** encodes ASCII characters to hexadecimal and display on JSlider

## Domain description

In the Martian, Matthew Damon is stuck on Mars. He has no way of communicating with Earth, until
he digs up the Mars Pathfinder, an old rover that NASA lost contact with back in 1997.

In the scene in question, Matthew discovers that he can use the rover’s (still functioning)
camera to establish a crude form of two-way communication with NASA back on Earth.
Naturally, Matthew can write on a white board and show this to the camera to speak to
NASA, but NASA can only communication back by using the camera, and its ability to
turn 360 degrees horizontally, as a crude form of pointing device. So, with three signs
placed into the ground on Mars, NASA can remotely point the camera to a
sign, and Matthew can check to see which sign the camera is being pointed at in order to
obtain a response to some basic questions.

However, as pointed out in the film, this method does not scale well to prolonged commu-
nication. Moreover, the natural extension to this system, in which 26 signs (for each letter
of the alphabet) are positioned around the camera in a circle and then pointed to in turn
in order to spell out words, is not viable, given that with only 360 degrees of rotation avail-
able, it becomes difficult to determine the marginal difference in rotation between adjacent
letters.

Being the smart man that he is, Matthew realises that he actually only needs 16 signs
placed around the rover in order to facilitate full conversation. This is because the character
encoding system ASCII maps every letter of the alphabet to an 8-bit binary number, which
can in turn be easily translated into a pair of hexadecimal
numbers. Therefore, only 16 signs are needed because the hexadecimal system only consists
of 16 unique characters (0 - 9 and A - F). After informing NASA to communicate with
him using hexadecimal ASCII encoding, Matthew can place his 16 signs around the rover
and then note down a series of characters pointed to in turn by the rover’s camera. He can
then translate this series back to the full Latin alphabet using an ASCII table, remembering
that two hexadecimal characters stand for a single Latin character. Thus, communication
is established.

## Code

It's a Java program that accepts a series of words written in 
the Latin alphabet (entered by NASA on Earth, we might imagine), translates them into
hexadecimal (via ASCII encoding) and then outputs them to a graphical representation of
the rover’s pointing camera mechanism.

## Contributors

* **Frederico Midolo**
* **Amandine Jala** - [dine-j](https://github.com/dine-j)
