package model;

import java.io.File;

import producer_consumer.Resource;
import controller.GraphControllerInterface;

public interface GraphModelInterface {
	public boolean readFromFile(File file, Resource<String> resource);
	public boolean writeOnFile(GraphControllerInterface graph);
}
