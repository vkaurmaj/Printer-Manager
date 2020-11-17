######## MAKEFILE DOES NOT WORK #########


JFLAGS = -g
JC = javac -cp src
.SUFFIXES: .java .class
.java.class: 
	$(JC) $(JFLAGS) $<
 
CLASSES = \
	src/mainClass.java \
 	src/Disk.java \
 	src/DirectoryManager.java \
 	src/DiskManager.java \
 	src/Printer.java \
 	src/PrintJobThread.java \
 	src/ResourceManager.java \
 	src/FileInfo.java \
 	src/UserThread.java \
 	src/OSMainFrame.java
 
classes: 
	$(CLASSES:.java=.class)
	
all: 
	$(classes)
	
clean: 
	$(RM) ./src/*.class