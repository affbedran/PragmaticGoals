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
			for(int j=0;)) {

				int newEdgeIndex = (int) Math.random() * wf.getNodes().size();
				// System.out.println("Current Edges :" +
				// newNode.getEdges().size());
				// System.out.println("Edges per node: " + edgesPerNode +
				// "\nNodes on Wf: " + wf.getNodes().size());
				// System.out.println("Adding edge from node " + newEdgeIndex +
				// " to the new node");
				WorkflowNode edge = wf.getNodes().get(newEdgeIndex);
				edge.addEdge(newNode);
			}

			wf.addNode(newNode);
		}

		return wf;
	}
}
