/////////////////////////////////////////////////////////////////////////////
// Name:        minimal.cpp
// Purpose:     Minimal wxWidgets sample
// Author:      David S Register
// Modified by:
// Created:     04/01/98
// RCS-ID:      $Id: minimal.cpp 65971 2010-11-01 12:30:38Z PMO $
// Copyright:   (c) Julian Smart
// Licence:     wxWindows licence
/////////////////////////////////////////////////////////////////////////////

// ============================================================================
// declarations
// ============================================================================

// ----------------------------------------------------------------------------
// headers
// ----------------------------------------------------------------------------

// For compilers that support precompilation, includes "wx/wx.h".
#include "wx/wxprec.h"

#ifdef __BORLANDC__
    #pragma hdrstop
#endif

// for all others, include the necessary headers (this file is usually all you
// need because it includes almost all "standard" wxWidgets headers)
#ifndef WX_PRECOMP
    #include "wx/wx.h"
#endif


#include "chart1.h"
//#include "myapp.h"

// ----------------------------------------------------------------------------
// private classes
// ----------------------------------------------------------------------------

// Define a new application type, each program should derive a class from wxApp
class MyTApp : public wxApp
{
public:
    // override base class virtuals
    // ----------------------------

    // this one is called on application startup and is a good place for the app
    // initialization (doing it here and not in the ctor allows to have an error
    // return: if OnInit() returns false, the application terminates)
    virtual bool OnInit();
};

class MyPanel: public wxPanel
{
public:
    MyPanel(wxFrame *frame);
    virtual ~MyPanel();

    wxTextCtrl    *m_text;
    wxButton      *m_button;

    void OnButton(wxCommandEvent& event);

private:
DECLARE_EVENT_TABLE()
};

// Define a new frame type: this is going to be our main frame
class MyTFrame : public wxFrame
{
public:
    // ctor(s)
    MyTFrame(const wxString& title);

    // event handlers (these functions should _not_ be virtual)
    void OnQuit(wxCommandEvent& event);
    void OnAbout(wxCommandEvent& event);

private:
    MyPanel *m_panel;
    // any class wishing to process wxWidgets events must use this macro
DECLARE_EVENT_TABLE()
};

// ----------------------------------------------------------------------------
// constants
// ----------------------------------------------------------------------------

// IDs for the controls and the menu commands
enum
{
    // menu items
            Minimal_Quit = wxID_EXIT,

    // it is important for the id corresponding to the "About" command to have
    // this standard value as otherwise it won't be handled properly under Mac
    // (where it is special and put into the "Apple" menu)
            Minimal_About = wxID_ABOUT,

    Minimal_Button = wxID_HIGHEST,
    Minimal_Text,
};


IMPLEMENT_APP_NO_MAIN(MyApp);
//IMPLEMENT_APP(MyApp);
//IMPLEMENT_WX_THEME_SUPPORT;

int main(int argc, char *argv[])
{
    wxEntryStart( argc, argv );
    wxTheApp->CallOnInit();
    wxTheApp->OnRun();

    return 0;
}





// ----------------------------------------------------------------------------
// event tables and other macros for wxWidgets
// ----------------------------------------------------------------------------

// the event tables connect the wxWidgets events with the functions (event
// handlers) which process them. It can be also done at run-time, but for the
// simple menu events like this the static method is much simpler.
BEGIN_EVENT_TABLE(MyTFrame, wxFrame)
                EVT_MENU(Minimal_Quit,  MyTFrame::OnQuit)
                EVT_MENU(Minimal_About, MyTFrame::OnAbout)
                EVT_BUTTON(Minimal_Quit,  MyTFrame::OnQuit)
                EVT_BUTTON(Minimal_About, MyTFrame::OnAbout)
END_EVENT_TABLE()

BEGIN_EVENT_TABLE(MyPanel, wxPanel)
                EVT_BUTTON(Minimal_Button,  MyPanel::OnButton)
END_EVENT_TABLE()

// Create a new application object: this macro will allow wxWidgets to create
// the application object during program execution (it's better than using a
// static object for many reasons) and also implements the accessor function
// wxGetApp() which will return the reference of the right type (i.e. MyApp and
// not wxApp)
//IMPLEMENT_APP(MyApp)

// ============================================================================
// implementation
// ============================================================================

// ----------------------------------------------------------------------------
// the application class
// ----------------------------------------------------------------------------

// 'Main program' equivalent: the program execution "starts" here
bool MyTApp::OnInit()
{

    // call the base class initialization method, currently it only parses a
    // few common command-line options but it could be do more in the future
    if ( !wxApp::OnInit() )
        return false;

    //wxString tty("test");

    //wxLogMessage(tty);

    //wxWindow * par = new wxDialog(NULL, -1, "dialog");

    //wxButton *bb = new wxButton(par, -1);

    //wxWindow *w = dynamic_cast <wxWindow *> (bb);
    //wxButton *up = dynamic_cast <wxButton *> (w);

    // create the main application window
    MyTFrame *frame = new MyTFrame(_T("Minimal wxWidgets App") );
    //MyFrame *frame = new MyFrame( tty );

    // and show it (the frames, unlike simple controls, are not shown when
    // created initially)
    frame->Show(true);


    wxFileDialog *pd = new wxFileDialog(frame);
    pd->Show();

    // success: wxApp::OnRun() will be called which will enter the main message
    // loop and the application will run. If we returned false here, the
    // application would exit immediately.
    return true;
}

// ----------------------------------------------------------------------------
// main frame
// ----------------------------------------------------------------------------

// frame constructor
MyTFrame::MyTFrame(const wxString& title)
        : wxFrame(NULL, wxID_ANY, title)
{
    // set the frame icon
    ////SetIcon(wxICON(sample));

#if dsrwxUSE_MENUS
    // create a menu bar
    wxMenu *fileMenu = new wxMenu;

    // the "About" item should be in the help menu
    wxMenu *helpMenu = new wxMenu;
    helpMenu->Append(Minimal_About, "&About...\tF1", "Show about dialog");

    fileMenu->Append(Minimal_Quit, "E&xit\tAlt-X", "Quit this program");

    // now append the freshly created menu to the menu bar...
    wxMenuBar *menuBar = new wxMenuBar();
    menuBar->Append(fileMenu, "&File");
    menuBar->Append(helpMenu, "&Help");

    // ... and attach this menu bar to the frame
    SetMenuBar(menuBar);
#endif // wxUSE_MENUS

#if wxUSE_STATUSBAR
    // create a status bar just for fun (by default with 1 pane only)
    CreateStatusBar(2);
    SetStatusText(_T("Welcome to wxWidgets!") );
#endif // wxUSE_STATUSBAR

    m_panel = new MyPanel(this);
    SetSize(wxGetDisplaySize());
}


MyPanel::MyPanel( wxFrame *frame )
        : wxPanel( frame, wxID_ANY )
{
    wxSizer *sizer = new wxBoxSizer(wxVERTICAL);
    m_text = new wxTextCtrl(this, Minimal_Text, _T("text") );
    m_button = new wxButton(this, Minimal_Button, _T("Platform") );
    wxButton *m_button1 = new wxButton(this, Minimal_About, _T("About") );
    wxButton *m_button2 = new wxButton(this, Minimal_Quit, _T("Quit") );

    sizer->Add(m_text, wxSizerFlags().Expand().Border());
    sizer->AddSpacer(5);
    sizer->Add(m_button, wxSizerFlags().Expand().Border());
    sizer->AddSpacer(5);
    sizer->Add(m_button1, wxSizerFlags().Expand().Border());
    sizer->AddSpacer(5);
    sizer->Add(m_button2, wxSizerFlags().Expand().Border());
    sizer->Layout();
    SetSizerAndFit(sizer);
}

// event handlers

void MyTFrame::OnQuit(wxCommandEvent& WXUNUSED(event))
{
    // true is to force the frame to close
    Close(true);
}

void MyTFrame::OnAbout(wxCommandEvent& WXUNUSED(event))
{
    wxMessageBox(wxString::Format
                         (
                                 _T("Welcome to %s!\n"
                                    "\n"
                                    "This is the minimal wxWidgets sample\n"
                                    "running under %s."),
                                 wxVERSION_STRING,
                                 wxGetOsDescription()
                         ),
                 _T("About wxWidgets minimal sample"),
                 wxOK | wxICON_INFORMATION,
                 this);
}

void MyPanel::OnButton(wxCommandEvent& WXUNUSED(event))
{
    // Show wxWidgets information:
    wxInfoMessageBox(this);
}

MyPanel::~MyPanel()
{
}

