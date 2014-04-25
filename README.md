mezzanine-client
================

Upgraded version of the Android Gallery application. Provides higher level search and similarity operations to users.


To Dos: 
-Merge Abhinav's code into the client to incorporate Face Detection
- Run KMeans Clustering on the Client Side
- Tune random restarts to retain acceptable speeds
- On client-side Scikit-Learn - 12-15 features were shown - up to 20 might make sense:
- No. of clusters? I think something like a heuristic algorithm can be used to determine number of clusters
  As some ratio of the total number of images.
- Clustering will be run on the Android Side using a port of Weka called Weka-for-Android. Make sure you satisfy all the Weka dependencies during the porting. 
- Search bar needs to be added.
- Custom 'cluster-view' carousel needs to be added. Decision : Carousel to choose cluster -> GridView to display images, or vice versa?
- Query expansion using WordNet : Generate mappings.
