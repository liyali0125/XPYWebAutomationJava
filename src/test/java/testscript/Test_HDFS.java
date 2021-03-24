/*
 * @FileName Test_HDFS: test scripts of hdfs
 * @outhor davieyang
 * @create 2018-08-20 17:59
 */
package testscript;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.davieyang.util.paas.HDFSVerification;

public class Test_HDFS {


    public class HDFSUtilTest {

        public String uri = "hdfs://192.168.1.118:9000";
        public String dir = "/user/output1";
        public String parentDir = "/user";

        @Test
        public void testMkdirNull1() {
            try {
                assertEquals(false, HDFSVerification.mkdir(null));
                assertEquals(false, HDFSVerification.mkdir(" "));
                assertEquals(false, HDFSVerification.mkdir(""));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testMkdirNormal1() {
            try {
                HDFSVerification.deleteDir(dir);
                boolean result = HDFSVerification.mkdir(dir);
                assertEquals(true, result);

                List<String> listFile = HDFSVerification.listAll(parentDir);
                boolean existFile = false;
                for (String elem : listFile) {
                    if (elem.equals(uri + dir)) {
                        existFile = true;
                        break;
                    }
                }
                assertEquals(true, existFile);
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

        @Test
        public void testDeleteDirNull1() {
            try {
                assertEquals(false, HDFSVerification.deleteDir(null));
                assertEquals(false, HDFSVerification.deleteDir(""));
                assertEquals(false, HDFSVerification.deleteDir(" "));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testDeleteDir() {
            try {
                assertEquals(true, HDFSVerification.mkdir(dir));
                assertEquals(true, HDFSVerification.deleteDir(dir));
                List<String> listFile = HDFSVerification.listAll(parentDir);
                boolean existFile = false;
                for (String elem : listFile) {
                    if (uri + dir == elem) {
                        existFile = true;
                        break;
                    }
                }
                assertEquals(false, existFile);
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

        @Test
        public void testListAllNull1() {
            try {
                List<String> listFile = new ArrayList<String>();
                assertEquals(listFile.toString(), HDFSVerification.listAll(null).toString());
                assertEquals(listFile.toString(), HDFSVerification.listAll(" ").toString());
                assertEquals(listFile.toString(), HDFSVerification.listAll("").toString());
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testListAllEmptyFolder() {
            try {
                HDFSVerification.deleteDir(dir);
                assertEquals(true, HDFSVerification.mkdir(dir));
                List<String> listFile = HDFSVerification.listAll(dir);
                assertEquals(0, listFile.size());
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }




        @Test
        public void testListAllNotExistFolder() {
            try {
                HDFSVerification.deleteDir(dir);
                List<String> listFile = HDFSVerification.listAll(dir);
                assertEquals(0, listFile.size());
            } catch (Exception ex) {
                assertEquals(true, true);
            }
        }

        @Test
        public void testUploadLocalFile2HDFSNull1() {
            try {
                assertEquals(false, HDFSVerification.uploadLocalFile2HDFS(null, null));
                assertEquals(false, HDFSVerification.uploadLocalFile2HDFS("", ""));
                assertEquals(false, HDFSVerification.uploadLocalFile2HDFS(" ", " "));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testUploadLocalFile2HDFS() {
            String localFile = "F:/Program Files/eclipse/eclipse.ini";
            String remoteFile = dir + "/eclipse.ini";

            try {
                HDFSVerification.mkdir(dir);
                HDFSVerification.deleteHDFSFile(remoteFile);
                assertEquals(true, HDFSVerification.uploadLocalFile2HDFS(localFile, remoteFile));
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

        @Test
        public void testUploadLocalFile2HDFSLocalNotExist() {
            String localFile = "F:/Program Files/eclipse/eclipse2.ini";
            String remoteFile = dir + "/eclipse.ini";

            try {
                assertEquals(true, HDFSVerification.mkdir(dir));
                HDFSVerification.deleteHDFSFile(remoteFile);
                HDFSVerification.uploadLocalFile2HDFS(localFile, remoteFile);
            } catch (Exception ex) {
                assertEquals(true, true);
            }
        }

        @Test
        public void testCreateNewHDFSFileNull1() {
            try {
                assertEquals(false, HDFSVerification.createNewHDFSFile(null, null));
                assertEquals(false, HDFSVerification.createNewHDFSFile(" ", " "));
                assertEquals(false, HDFSVerification.createNewHDFSFile("", ""));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testCreateNewHDFSFileNormal1() {
            try {
                String newFile = dir + "/file1.txt";
                String content = "hello file1";

                HDFSVerification.deleteHDFSFile(newFile);
                assertEquals(true, HDFSVerification.createNewHDFSFile(newFile, content));
                String result = new String(HDFSVerification.readHDFSFile(newFile));
                assertEquals(content, result);
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

        @Test
        public void testCreateNewHDFSFileFoldNotexist1() {
            try {
                String newFile = dir + "/file1.txt";
                String content = "hello file1";

                assertEquals(true, HDFSVerification.deleteDir(dir));
                assertEquals(true, HDFSVerification.createNewHDFSFile(newFile, content));
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

        @Test
        public void testDeleteHDFSFileNull1() {
            try {
                assertEquals(false, HDFSVerification.deleteHDFSFile(null));
                assertEquals(false, HDFSVerification.deleteHDFSFile(" "));
                assertEquals(false, HDFSVerification.deleteHDFSFile(""));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testDeleteHDFSFile() {
            this.testUploadLocalFile2HDFS();
            try {
                String remoteFile = dir + "/eclipse.ini";
                assertEquals(true, HDFSVerification.deleteHDFSFile(remoteFile));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testDeleteHDFSFileNotexist1() {
            try {
                String remoteFile = dir + "/eclipse2.ini";
                assertEquals(false, HDFSVerification.deleteHDFSFile(remoteFile));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testReadHDFSFileNull1() {
            try {
                assertEquals(null, HDFSVerification.readHDFSFile(null));
                assertEquals(null, HDFSVerification.readHDFSFile(" "));
                assertEquals(null, HDFSVerification.readHDFSFile(""));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testReadHDFSFile() {
            this.testUploadLocalFile2HDFS();
            try {
                String remoteFile = dir + "/eclipse.ini";
                String result = new String(HDFSVerification.readHDFSFile(remoteFile));
                assertEquals(true, result.length() > 0);
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

        @Test
        public void testAppendNull1() {
            try {
                assertEquals(false, HDFSVerification.append(null, null));
                assertEquals(false, HDFSVerification.append(" ", " "));
                assertEquals(false, HDFSVerification.append("", ""));
            } catch (Exception ex) {
                assertEquals(true, false);
            }
        }

        @Test
        public void testAppend() {
            try {
                String newFile = dir + "/file1.txt";
                String content1 = "hello append1\r\n";
                String content2 = "hello append2\r\n";

                HDFSVerification.deleteHDFSFile(newFile);
                assertEquals(true, HDFSVerification.createNewHDFSFile(newFile, ""));
                assertEquals(true, HDFSVerification.append(newFile, content1));
                assertEquals(content1, new String(HDFSVerification.readHDFSFile(newFile)));
                assertEquals(true, HDFSVerification.append(newFile, content2));
                assertEquals(content1 + content2, new String(HDFSVerification.readHDFSFile(newFile)));
            } catch (Exception ex) {
                ex.printStackTrace();
                assertEquals(true, false);
            }
        }

    }
}
