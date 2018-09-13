package system_dependencies;

import org.junit.Assert;
import org.junit.Test;

import static system_dependencies.SystemDependencies.FileStatus.EXPLICITYLY_INSTALLED;
import static system_dependencies.SystemDependencies.FileStatus.IMPLICITYLY_INSTALLED;
import static system_dependencies.SystemDependencies.FileStatus.NOT_INSTALLED;

/**
 * Created by lxie on 9/12/18.
 */
public class SystemDependenciesUnitTest {

    SystemDependencies sdep = new SystemDependencies();

    public SystemDependenciesUnitTest() {
        setupDependencies();
    }

    @Test
    public void testGetID(){
        // first id is TELNET(1)
        int id = sdep.getID("TELNET");
        Assert.assertEquals(id, 1);

        // last id is HTML(6), 6 files in total
        id = sdep.getID("HTML");
        Assert.assertEquals(id, 6);

        // add a new id = 7 for FIREWALL(7)
        id = sdep.getID("FIREWALL");
        Assert.assertEquals(id, 7);
    }

    @Test
    public void testNeeded(){
        /* HTML(6) is needed by BROWSER(5) */
        sdep.install(5, true);
        boolean res = sdep.needed(6);
        Assert.assertEquals(res, true);

        /* FIREWALL(7) is not needed by anyone */
        res = sdep.needed(7);
        Assert.assertEquals(res, false);

        /* a non-existing file id = 15 is not needed */
        res = sdep.needed(15);
        Assert.assertEquals(res, false);
    }

    @Test
    public void testInstall(){
        /* install NETCARD(3) -> NETCARD(3) */
        sdep.install(3, true);
        Assert.assertEquals(sdep.status[3], EXPLICITYLY_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(3), true);

        /* install TELNET(1) -> TCPIP(2), TELNET(1) */
        sdep.install(1, true);
        Assert.assertEquals(sdep.status[2], IMPLICITYLY_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(2), true);
        Assert.assertEquals(sdep.status[1], EXPLICITYLY_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(1), true);

        /* install a new file foo(7) -> foo(7) */
        int id = sdep.getID("foo");
        sdep.install(7, true);
        Assert.assertEquals(sdep.status[7], EXPLICITYLY_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(7), true);

        /* install a file that already exists, nothing should change */
        sdep.install(7, true);
        Assert.assertEquals(sdep.status[7], EXPLICITYLY_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(7), true);

    }

    @Test
    public void testRemove(){

        testInstall();

        /* remove NETCARD(3) -> still needed by others */
        sdep.remove(3, true);
        Assert.assertEquals(sdep.status[3], EXPLICITYLY_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(3), true);

        /* remove TELNET(1) -> removed TELNET(1), TCPIP(2)*/
        sdep.remove(1, true);
        Assert.assertEquals(sdep.status[1], NOT_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(1), false);
        // TCPIP implicitely installed is also removed (not needed by others)
        Assert.assertEquals(sdep.status[2], NOT_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(2), false);

        /* remove foo(7) -> removed foo(7) */
        sdep.remove(7, true);
        Assert.assertEquals(sdep.status[1], NOT_INSTALLED);
        Assert.assertEquals(sdep.installed.contains(7), false);

    }

    /* this function sets up the dependency graphs */
    public void setupDependencies(){
        String[] depends = { "DEPEND TELNET TCPIP NETCARD",
                             "DEPEND TCPIP NETCARD",
                             "DEPEND DNS TCPIP NETCARD",
                             "DEPEND BROWSER TCPIP HTML"};
        for (String line : depends) {
            String[] params = line.split(" ");
            int i1 = sdep.getID(params[1]);
                /* cmd is DEPEND */
            if(params[0].equals("DEPEND")) {
                // add dependencies to the graphs
                for(int i = 2; i < params.length; ++i) {
                    int i2 = sdep.getID(params[i]);
                    sdep.depend.get(i1).add(i2);
                    sdep.depend2.get(i2).add(i1);
                }
            }
        }

    }














}
