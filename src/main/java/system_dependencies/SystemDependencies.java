package system_dependencies;

import java.util.*;

import static system_dependencies.SystemDependencies.FileStatus.EXPLICITYLY_INSTALLED;
import static system_dependencies.SystemDependencies.FileStatus.IMPLICITYLY_INSTALLED;
import static system_dependencies.SystemDependencies.FileStatus.NOT_INSTALLED;

/**
 * The SystemDependencies program implements an application that
 * supports file dependencies during file installations and
 * removals.
 *
 * @author  Liang Xie
 * @version 1.0
 * @since   2018-09-12
 */
public class SystemDependencies {

    public enum FileStatus
    {
        NOT_INSTALLED, EXPLICITYLY_INSTALLED, IMPLICITYLY_INSTALLED;
    }

    private final int maxn =10000; // maximum 10000 files in total
    private int cnt = 0;
    /* a mapping between file name and id */
    public Map<String, Integer> name2id = new HashMap<>();

    public String[] name = new String[maxn];

    /* file dependency graphs - depend on and depended on */
    public List<List<Integer>> depend = new ArrayList<>();  // depend on
    public List<List<Integer>> depend2 = new ArrayList<>(); // depended on

    /* status array for the files */
    public FileStatus[] status = new FileStatus[maxn];

    /* installed files in a list */
    public List<Integer> installed = new ArrayList<>();

    /* constructor */
    public SystemDependencies() {
        for (int i = 0; i < maxn; ++i) {
            this.depend.add(new ArrayList<>());
            this.depend2.add(new ArrayList<>());
        }
        Arrays.fill(status, NOT_INSTALLED);
        Arrays.fill(name, "");
    }

    /**
     * This method is used to obtain an integer ID given the file
     * name string.
     * @param itemName file name string
     * @return int returns an integer ID.
     */
    public int getID(String itemName) {
        if(!name2id.containsKey(itemName)) {
            // create an integer ID if does not exist
            name[++cnt] = itemName;
            name2id.put(itemName, cnt);
        }
        return name2id.get(itemName);

    }

    /**
     * This method is used to check if a file is needed by dependants
     * @param item file ID
     * @return boolean returns true if there is dependants on the file.
     */
    public boolean needed(int item) {
        for(int i = 0; i < depend2.get(item).size();i++)
            if(status[depend2.get(item).get(i)] != NOT_INSTALLED) return true;
        return false;
    }

    /**
     * This method is used to install a file given the current dependencies
     * @param item file ID
     * @param toplevel whether the file is at top-level
     * @return void
     */
    public void install(int item, boolean toplevel) {
        if(status[item] == NOT_INSTALLED) {
            // for all dependents call install (not toplevel)
            for(int i = 0; i < depend.get(item).size();i++) {
                install(depend.get(item).get(i), false);
            }
            System.out.println("   Installing " + name[item]);
            // toplevel - explicitly installed
            status[item] = toplevel ? EXPLICITYLY_INSTALLED : IMPLICITYLY_INSTALLED;
            installed.add(item);
        }
    }

    /**
     * This method is used to remove a file given the current dependencies
     * @param item file ID
     * @param toplevel whether the file is at top-level
     * @return void
     */
    public void remove(int item, boolean toplevel) {
        /* remove the file that has no dependents and is at toplevel or
        implicitly installed */
        if((toplevel || status[item] == IMPLICITYLY_INSTALLED) &&!needed(item)) {
            status[item] = NOT_INSTALLED;
            installed.remove(new Integer(item));
            System.out.println("   Removing " + name[item]);

            // for all dependents call remove (not toplevel)
            for(int i = 0; i < depend.get(item).size();i++) {
                remove(depend.get(item).get(i), false);
            }
        }
    }

    /**
     * This method prints out installed files according to the
     * installation order
     */
    public void list() {
        for(int i = 0; i < installed.size(); i++) {
            System.out.println("   " + name[installed.get(i)]);
        }
    }

    public static void main(String[] args) {
        SystemDependencies sdep = new SystemDependencies();
        String line = "", cmd = "";

        Scanner scanner = new Scanner(System.in);
        while(true) {
            line = scanner.nextLine();
            System.out.println(line);
            String[] params = line.split(" ");

            /* cmd is END */
            if(params[0].equals("END")) break;

            /* cmd is LIST */
            if(params[0].equals("LIST")) sdep.list();
            else {
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
                /* cmd is INSTALL */
                else if(params[0].equals("INSTALL")) {
                    if(sdep.status[i1] != NOT_INSTALLED)
                        System.out.println("   " + params[1] + " is already installed.");
                    else
                        sdep.install(i1, true);
                }
                /* cmd is REMOVE */
                else {
                    if(sdep.status[i1] == NOT_INSTALLED)
                        System.out.println("   " + params[1] + " is not installed.");
                    else if(sdep.needed(i1))
                        System.out.println("   " + params[1] +" is still needed.");
                    else sdep.remove(i1, true);

                }

            }
        }
    }












}
