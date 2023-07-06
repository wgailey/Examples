HISTSIZE=1000
################################################################
if [ -f ~/.bash_aliases ]; then
    . ~/.bash_aliases
fi
############################General##############################
shopt -s histappend
shopt -s checkwinsize
############################Exports###############################
shopt -u sourcepath
export PS1='\[\e[44m\]\u@\H : \d : \t >\[\e[m\]'
export HISTFILESIZE=4000
export HISTCONTROL=ignoreboth
LS_COLORS='di=1;35:fi=93:ln=5'
export LS_COLORS
############################Aliases###############################
alias pos='ssh 404'
alias wtfau='top | grep'
alias wtfii='ls -al | more'
alias wtftii='echo $time'
alias wtfit='echo $date'
alias gtfo='cd ../'
alias wtfdid='history | grep'
alias lsd='ls' ##works great with the colors
############################Command substitution#################
cp='cp -i'
rm='rm -i'
mv='mv -i'
ls='ls --color'
############################Exported Functions##################
function pointless () { read dir; mkdir $dir; mv $dir; }
export -f pointless
function getit () { read pkg; sudo apt-get -y install $pkg; }
export -f getit
function why () { echo "uptime"; echo $uptime; echo "uname"; echo $uname -a; echo "free"; echo $free;echo "disk usage"; df -h }
export -f why
##########################Settings############################
set -o noclobber
set -o notify
set -xv
