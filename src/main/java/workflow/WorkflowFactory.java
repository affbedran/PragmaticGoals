package workflow;

import workflow.datatype.Workflow;
import workflow.datatype.WorkflowNode;

public class WorkflowFactory {

	public Workflow createRandomWorkflow(int nodes, int edgesPerNode) {
		if (nodes == 0)
			return null;

		System.out.println("Creating nodes ");

		Workflow wf = new Workflow(new WorkflowNode("Node0"));
		for (int i = 1; i < nodes; i++) {
			WorkflowNode newNode = new WorkflowNode("Node" + i);
			System.out.println("Creating node " + i);
			for (int j = 0; j < edgesPerNode && j < wf.getNodes().size() - 1; j++) {

<<<<<<< HEAD
				int newEdgeIndex = ((int) (Math.random()) * wf.getNodes().size());
				System.out.println("J: " + j);
				System.out.println("Edges per node: " + edgesPerNode + "\nNodes on Wf: " + wf.getNodes().size());
				System.out.println("Adding edge from node " + newEdgeIndex + " to the new node");
				WorkflowNode edge = wf.getNodes().get(newEdgeIndex);
				if (edge.getEdges().contains(newNode)) {
					// j--; // if the picked node already contains the newNode
					// as
					// an edge, pick again
=======
				int newEdgeIndex = (int) (Math.random() * wf.getNodes().size());
				WorkflowNode originalNode = wf.getNodes().get(newEdgeIndex);
				if (originalNode.getEdges().contains(newNode)) {
					j--; // if the picked node already contains the newNode
							// as
							// an edge, pick again
>>>>>>> cfd8c2dd464727a1738bd6d79f9f97765fd6dcbb
				} else
					originalNode.addEdge(newNode);
			}

			wf.addNode(newNode);
		}

		return wf;
	}
}
