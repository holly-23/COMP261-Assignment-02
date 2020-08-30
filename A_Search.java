import java.util.*;

public class A_Search {
   private Queue<FringeObject> fringe = new PriorityQueue<>(); //create new fringe object
   List<Node> visited = new ArrayList<>();
   private Graph graph = Mapper.graph;
   Map<String, Double> roadMap = new HashMap<>();
   public A_Search(){}
   public String A_Search(Node s, Node e){
      FringeObject sObject = new FringeObject(s, null, 0, s.location.distance(e.location));
      fringe.offer(sObject);
      while(!fringe.isEmpty()){
         FringeObject pObject = fringe.poll();        //remove from pQ

         Node currentNode = pObject.getCurrent();
         Node prevNode = pObject.getPrev();

         if(!visited.contains(currentNode)){
            visited.add(currentNode);
            currentNode.setPrev(prevNode);
            if(currentNode == e){
               break;
            }
            for(Segment seg : currentNode.segments){
               if(!(seg.road.oneway==1 && seg.end == currentNode)){ //makes route allow for one way
               Node neighbour;
                  if(!currentNode.equals(seg.start)){
                     neighbour = seg.start;
                  }
                  else{
                     neighbour = seg.end;
                  }
                  if(!visited.contains(neighbour)){
                     double newG = pObject.getG();
                     newG += seg.length;
                     double newF = newG + currentNode.location.distance(neighbour.location);
                     //add new object to fringe
                     FringeObject newObject = new FringeObject(neighbour, currentNode, newG, newF);
                     fringe.offer(newObject);
                  }
               }
            }
         }
      }
      String road = "start " + s.nodeID + " end " + e.nodeID + "\nroads ";
      road = starPath(e, road, 0);
      return road;
   }
   public String starPath(Node node, String text, double total){
      Node prevNode = node.getPrev();
      while(!(prevNode==null)){
         for(Segment segment : node.segments){
            if(segment.start==prevNode || segment.end==prevNode){
               graph.pathSeg.add(segment);
               Road road = segment.road;
               String roadNames = road.name;
               double segmentLength = segment.length;
               if(roadMap.containsKey(roadNames)){
                  double dis = roadMap.get(roadNames);
                  roadMap.put(roadNames, segmentLength + dis);
               }
               else{
                  roadMap.put(roadNames, segmentLength);
               }
            }
         }
         node = node.getPrev();
         prevNode = node.getPrev();
      }
      for(Map.Entry<String, Double> path:roadMap.entrySet()){
         text += path.getKey() + ": " + path.getValue() + "km \n";
         total += path.getValue();                 //gets segment distances and adds together
      }
      text += "\n Total Distance: " + total + "km";
      return text;
   }
   }

