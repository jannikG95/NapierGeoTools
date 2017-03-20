# Simplified GraphHopper API

## Get Started

To get started using Eclipse you need to install Git (e.g. EGit http://www.eclipse.org/egit/) and Maven (e.g. Maven2Eclipse http://www.eclipse.org/m2e/). 

After that import the Simplified GraphHopper API via file -> import -> git -> projects from Git -> clone URL and then paste in https://github.com/jannikG95/NapierGeoTools. Now you can select the projects you want to import, for GraphHopper choose SimplifiedGraphHopper and NapierGeoTools.common.

Within the SimplifiedGraphHopper project you find a .zip file called graphhopper-master. Move this to a place on your local file system and unpack it.
Now you must import the GraphHopper routing engine. Therefore go to file -> import -> maven -> existing maven projects and browse to the unpacked graphhopper-master file. Import it. 

Now you can start developing.
