# fo4-BodySlideToBodyGen
A java file that parses BodySlide XML files and create template.ini files suitable for Fallout 4

Right now, it is a simple command line:
java -jar filename [variance]
The jar will create a templates.ini file from the passed BodySlide XML presets. The resulting file is suitable for using in BodyGen with LooksMenu for Fallout 4. A variance can be added that will +/- a percentage from the sliders, capping at Slider value 100/BodyGen value 1.00.

Suggestions welcome.
