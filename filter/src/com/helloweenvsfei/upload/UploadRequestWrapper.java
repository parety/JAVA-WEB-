package com.helloweenvsfei.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

public class UploadRequestWrapper extends HttpServletRequestWrapper {

	private static final String MULTIPART_HEADER = "Content-type";

	// �Ƿ����ϴ��ļ�
	private boolean multipart;

	// map���������е���
	private Map<String, Object> params = new HashMap<String, Object>();

	@SuppressWarnings("all")
	public UploadRequestWrapper(HttpServletRequest request) {

		super(request);

		// �ж��Ƿ�Ϊ�ϴ��ļ�
		multipart = request.getHeader(MULTIPART_HEADER) != null
				&& request.getHeader(MULTIPART_HEADER).startsWith(
						"multipart/form-data");

		if (multipart) {

			try {
				// ʹ��apache�Ĺ��߽���
				DiskFileUpload upload = new DiskFileUpload();
				upload.setHeaderEncoding("utf8");

				// ������������е��ı������ļ���
				List<FileItem> fileItems = upload.parseRequest(request);

				for (Iterator<FileItem> it = fileItems.iterator(); it.hasNext();) {

					// ����
					FileItem item = it.next();
					if (item.isFormField()) {

						// ������ı���ֱ�ӷŵ�map��
						params.put(item.getFieldName(), item.getString("utf8"));

					} else {

						// ����Ϊ�ļ����Ȼ�ȡ�ļ�����
						String filename = item.getName().replace("\\", "/");
						filename = filename
								.substring(filename.lastIndexOf("/") + 1);

						// ���浽ϵͳ��ʱ�ļ�����
						File file = new File(System
								.getProperty("java.io.tmpdir"), filename);

						// �����ļ�����
						OutputStream ous = new FileOutputStream(file);
						ous.write(item.get());
						ous.close();

						// �ŵ�map��
						params.put(item.getFieldName(), file);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object getAttribute(String name) {

		// ���Ϊ�ϴ��ļ������map��ȡֵ
		if (multipart && params.containsKey(name)) {
			return params.get(name);
		}
		return super.getAttribute(name);
	}

	@Override
	public String getParameter(String name) {

		// ���Ϊ�ϴ��ļ������map��ȡֵ
		if (multipart && params.containsKey(name)) {
			return params.get(name).toString();
		}
		return super.getParameter(name);
	}

	public static void main(String[] args) {

		System.out.println(System.getProperties().toString().replace(", ",
				"\r\n"));

	}

}
