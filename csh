################################################
#!/bin/csh

echo -n "What was your grade on the test? "
set grade = $<
switch ("$grade")


case "$grade >= 90 && $grade <= 1000" :
        echo "You got an A!"
breaksw
case "$grade >= 80 && $grade <= 89" :
        echo "You got a B."
breaksw
case "$grade >= 70 && $grade <= 79" :
        echo "You're average."
breaksw
case "$grade >= 60 && $grade <= 69" :
        echo "Better study harder"
breaksw
default :
        echo "Invalid Input"
breaksw

endsw
#######testing###Note:the echos are not complete########
#!/bin/csh -f

echo -n "What file would you like to test? "
set test = $<
echo -n "What yould you like to test it for?"
echo "1)Is it readable?"
echo "2)Is it a symbolic link?"
echo "3)Does it have hidden attributes?"
set choice = $<
expr{}
if choice = 1 then
echo readable
if choice = 2 then
echo link
if choice = 3 then
echo attrib
else echo "That is not a valid entry"

end

######################numbers########################
#!/bin/csh

echo -n "whats your lucky number?"
set number = $<

if ($number != 13) then

else echo "Unlucky number"
exit 1
########################end##########################
