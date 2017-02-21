package KML_Object.geometry;

import java.util.ArrayList;

import HelperClasses.LinkedOutput;
import HelperClasses.TreeNode;
import KML_Object.KML_object;

public class Polygon extends KML_object implements KML_Geometry{

	/*
	 * Information Area (Source: KML Reference Google Developers):
	 * 
	 * A Polygon is defined by an outer boundary and 0 or more inner boundaries.
	 * The boundaries, in turn, are defined by LinearRings. When a Polygon is
	 * extruded, its boundaries are connected to the ground to form additional
	 * polygons, which gives the appearance of a building or a box. Extruded
	 * Polygons use <PolyStyle> for their color, color mode, and fill.
	 * 
	 * The <coordinates> for polygons must be specified in counterclockwise
	 * order. Polygons follow the "right-hand rule," which states that if you
	 * place the fingers of your right hand in the direction in which the
	 * coordinates are specified, your thumb points in the general direction of
	 * the geometric normal for the polygon. (In 3D graphics, the geometric
	 * normal is used for lighting and points away from the front face of the
	 * polygon.) Since Google Earth fills only the front face of polygons, you
	 * will achieve the desired effect only when the coordinates are specified
	 * in the proper order. Otherwise, the polygon will be gray.
	 * 
	 */

	private boolean extruded;
	private boolean tessellated;
	private String altitudeMode;
	private LinearRing outerBoundry = null;
	private ArrayList<LinearRing> innerBoundryList = new ArrayList<>();
	
	public String isExtruded() {
		return (extruded) ? "1" : "0";
	}

	public void setExtruded(boolean extruded) {
		this.extruded = extruded;
	}

	public String isTessellated() {
		return (tessellated) ? "1" : "0";
	}

	public void setTessellated(boolean tessellated) {
		this.tessellated = tessellated;
	}

	public String getAltitudeMode() {
		return altitudeMode;
	}

	public void setAltitudeMode(String altitudeMode) {
		this.altitudeMode = altitudeMode;
	}

	public LinearRing getOuterBoundry() {
		return outerBoundry;
	}

	public void setOuterBoundry(LinearRing outerBoundry) {
		this.outerBoundry = outerBoundry;
	}

	public ArrayList<LinearRing> getInnerBoundryList() {
		return innerBoundryList;
	}

	public void addInnerBoundry(LinearRing innerBoundry) {
		this.innerBoundryList.add(innerBoundry);
	}

	public TreeNode<LinkedOutput> getLinkedOutput (){
		
		TreeNode<LinkedOutput> root = super.getLinkedOutput();

		root.addChild(new LinkedOutput("extrude", this.isExtruded(), false));
		root.addChild(new LinkedOutput("tessellate", this.isTessellated(), false));
		root.addChild(new LinkedOutput("altitudeMode", this.getAltitudeMode(), false));
		TreeNode<LinkedOutput> rootOuter =  root.addChild(new LinkedOutput("outerBoundaryIs", null, false));
		rootOuter.addTreeNode(outerBoundry.getLinkedOutput());
		for (LinearRing linearRing : innerBoundryList) {
			TreeNode<LinkedOutput> rootInner = root.addChild(new LinkedOutput("innerBoundaryIs", null, false));
			rootInner.addTreeNode(linearRing.getLinkedOutput());
		}
		
		return root; 
	}
	
	

}