/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2010-2012 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.cmis.service;

import java.util.Map;

import com.ephesoft.dcma.core.DCMAException;
import com.ephesoft.dcma.da.id.BatchInstanceID;

/**
 * This service is responsible for uploading all the output files to the repository folder. This will reads the batch.xml file. It
 * finds the names of multipage tif and pdf files from the batch.xml. Then it upload these files to the repository main root folder. At
 * a time it will upload only pdf or tif files.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see com.ephesoft.dcma.cmis.service.CMISExportServiceImpl
 */
public interface CMISExportService {

	/**
	 * This method reads the batch.xml file. It finds the names of multipage tif and pdf files from the batch.xml. Then it upload these
	 * files to the repository main root folder. At a time it will upload only pdf or tif files.
	 * 
	 * @param batchInstanceID {@link BatchInstanceID}
	 * @param pluginWorkflow {@link String}
	 * @throws DCMAException
	 */
	void exportContent(final BatchInstanceID batchInstanceID, final String pluginWorkflow) throws DCMAException;

	/**
	 * This method deletes documents for a particular batch based on the CMIS properties of that batch.
	 * 
	 * @param batchInstanceID {@link BatchInstanceID}
	 * @param pluginWorkflow {@link String}
	 * @throws DCMAException
	 */
	void deleteDocument(final BatchInstanceID batchInstanceID, final String pluginWorkflow) throws DCMAException;

	/**
	 * This method tests the batch connection to the repository server.
	 * 
	 * @param pluginPropertyValues {@link Map<String, String>} plugin properties of the batch class used for connection.
	 * @throws DCMAException {@link DCMAException} If not able to connect to repository server.
	 */
	Map<String, String> cmisConnectionTest(Map<String, String> pluginPropertyValues) throws DCMAException;

	/**
	 * This method to get the CMIS authentication URL.
	 * 
	 * @param pluginPropertyValues {@link Map<String, String>} plugin properties of the batch class used for connection.
	 */
	String getAuthenticationURL(Map<String, String> pluginPropertyValues);

	/**
	 * This method to get the tokens map.
	 * 
	 * @param pluginPropertyValues {@link Map<String, String>} plugin properties of the batch class used for connection.
	 * @throws DCMAException {@link DCMAException} If not able to connect to repository server.
	 */
	Map<String, String> getTokensMap(Map<String, String> pluginPropertyValues) throws DCMAException;
}
