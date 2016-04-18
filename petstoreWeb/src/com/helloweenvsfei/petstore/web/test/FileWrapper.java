package com.helloweenvsfei.petstore.web.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileWrapper {

	private File file;

	private Set<FileWrapper> children = new HashSet<FileWrapper>();

	public FileWrapper(File file) {

		this.file = file;

		File[] files = this.file.listFiles();

		for (int i = 0; files != null && i < files.length; i++) {
			FileWrapper wrapper = new FileWrapper(files[i]);
			children.add(wrapper);
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Set<FileWrapper> getChildren() {
		return children;
	}

	public void setChildren(Set<FileWrapper> children) {
		this.children = children;
	}

}
